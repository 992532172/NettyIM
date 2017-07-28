package net.wehotel.zl.service;

import io.netty.channel.Channel;
import net.wehotel.zl.api.domain.ChatMsgDomain;
import net.wehotel.zl.api.response.Result;

import net.wehotel.zl.commen.NettyMsgTypeEnmu;
import net.wehotel.zl.db.entity.ChatMsgInfo;
import net.wehotel.zl.rmq.RmqSender;
import net.wehotel.zl.util.NettyMsgSendUtil;
import net.wehotel.zl.db.dal.ChatMsgDAL;
import net.wehotel.zl.util.GsonUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatMsgService {
    private Logger logger = LoggerFactory.getLogger(ChatMsgService.class);
    @Autowired
    private ClientStatusService clientStatusService;
    @Autowired
    private ChatMsgDAL chatMsgDAL;
    @Autowired
    private RmqSender rmqSender;

    public Result sendChatMsg(ChatMsgDomain msgDomain) {
        Result rs = checkMsgParm(msgDomain);
        if (!Result.SUCCESS_CODE.equals(rs.getCode())) {
            logger.debug("聊天消息请求参数校验异常, rs:{}", rs);
            return rs;
        }
        if (ChatMsgDomain.SIMPLE_CHAT.equals(msgDomain.getMsgtype())) {
            dealSimpleMsg(msgDomain);
        }
        return rs;
    }

        /**
     * 用户上线时,发送历史消息
     *
     * @param userid
     */
    public void appendOutLineMsg(String userid){
        Channel client = clientStatusService.getClientById(userid);
        int page = 1;
        List<ChatMsgInfo> returnList = new ArrayList<>();
        List<ChatMsgInfo> msgList = chatMsgDAL.pageMsgByReceiver(userid, page);
        while(CollectionUtils.isNotEmpty(msgList)){
            returnList.addAll(msgList);
        }
        if(CollectionUtils.isEmpty(returnList)) return;
        NettyMsgSendUtil.sendNettyMsg(client, NettyMsgTypeEnmu.SIMPLE_CHAT_MSG_LIST.name(), GsonUtil.toJsonStr(returnList));
    }

    /**
     * 处理单人聊天消息
     *
     * @param msgDomain
     */
    private void dealSimpleMsg(ChatMsgDomain msgDomain) {
        Channel receiverChannel = clientStatusService.getClientById(msgDomain.getReceiverid());
        if (receiverChannel != null) {
            String returnmsg = GsonUtil.toJsonStr(msgDomain);
            NettyMsgSendUtil.sendNettyMsg(receiverChannel, NettyMsgTypeEnmu.SIMPLE_CHAT.name(), returnmsg);
        } else {
            try {
                boolean success = rmqSender.sendMsg(GsonUtil.toJsonStr(msgDomain));
                if(!success){
                    throw new Exception("MsgSendFailed");
                }
            } catch (Exception e) {
                logger.error("消息发送失败,msg:" + msgDomain.toString(), e);
            }
        }
    }

    private Result checkMsgParm(ChatMsgDomain msgDomain) {
        Result rs = new Result();
        if (msgDomain == null || StringUtils.isBlank(msgDomain.getMsgcontent())) {
            rs.setValue("-1", "消息内容不能为空");
            return rs;
        }
        if (StringUtils.isBlank(msgDomain.getMsgtype()) || StringUtils.isBlank(msgDomain.getReceiverid())
                || StringUtils.isBlank(msgDomain.getSpeakerid())) {
            rs.setValue("-1", "缺少必要参数");
            return rs;
        }
        return rs;
    }

}
