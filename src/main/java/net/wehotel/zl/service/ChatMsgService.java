package net.wehotel.zl.service;

import net.wehotel.zl.api.domain.ChatMsgDomain;
import net.wehotel.zl.api.response.Result;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatMsgService {
    private Logger logger = LoggerFactory.getLogger(ChatMsgService.class);
    @Autowired
    private MsgSender msgSender;

    public Result sendChatMsg(ChatMsgDomain msgDomain) {
        Result rs = checkMsgParm(msgDomain);
        if (!Result.SUCCESS_CODE.equals(rs.getCode())) {
            logger.debug("聊天消息请求参数校验异常, rs:{}", rs);
            return rs;
        }
        if(ChatMsgDomain.SIMPLE_CHAT.equals(msgDomain.getMsgtype())){
            msgSender.sendSimpleMsg(msgDomain);
        }
        
        return rs;
    }
    
    private Result checkMsgParm(ChatMsgDomain msgDomain) {
        Result rs = new Result();
        if(msgDomain == null || StringUtils.isBlank(msgDomain.getMsgcontent())){
            rs.setValue("-1", "消息内容不能为空");
            return rs;
        }
        if(StringUtils.isBlank(msgDomain.getMsgtype()) || StringUtils.isBlank(msgDomain.getReceiverid()) || StringUtils.isBlank(msgDomain.getSpeakerid())){
            rs.setValue("-1", "缺少必要参数");
            return rs;
        }
        return rs;
    }

}
