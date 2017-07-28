package net.wehotel.zl.service;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;

import java.util.Date;

import net.wehotel.zl.api.domain.ChatMsgDomain;
import net.wehotel.zl.api.domain.UserDomain;
import net.wehotel.zl.api.request.BaseNettyMsg;
import net.wehotel.zl.api.response.Result;
import net.wehotel.zl.commen.NettyMsgTypeEnmu;
import net.wehotel.zl.util.GsonUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NettyRequestDispatcher {
    private Logger logger = LoggerFactory.getLogger(NettyRequestDispatcher.class);

    @Autowired
    private UserService userService;
    @Autowired
    private ClientStatusService clientStatusService;
    @Autowired
    private ChatMsgService chatMsgService;

    public String dispatch(ChannelHandlerContext ctx, String requestData) {
        Result rs = new Result();
        BaseNettyMsg request = GsonUtil.json2Obj(requestData, BaseNettyMsg.class);
        if (NettyMsgTypeEnmu.LOGIN.name().equals(request.getRqType())) {
            try {
                String loginRequest = request.getMsgContent();
                UserDomain domain = GsonUtil.json2Obj(loginRequest, UserDomain.class);
                rs = userService.login(domain);
                if (Result.SUCCESS_CODE.equals(rs.getCode())) {
                    Channel channel = ctx.channel();
                    Channel returnChannel = clientStatusService.addClient(rs.getMsg(), channel);
                    chatMsgService.appendOutLineMsg(rs.getMsg());
                    if (!channel.equals(returnChannel)) {
                        multiLogin(returnChannel);
                    }
                }
            } catch (Exception e) {
                rs.setValue("-1", "登录失败:未知异常");
                logger.error("", e);
            }
        } else if (NettyMsgTypeEnmu.SIMPLE_CHAT.name().equals(request.getRqType())) {
            ChatMsgDomain msgDomain = GsonUtil.json2Obj(request.getMsgContent(), ChatMsgDomain.class);
            msgDomain.setSendtime(new Date());
            rs = chatMsgService.sendChatMsg(msgDomain);
            return null;
        } else {
            rs.setValue("-1", "无法识别的请求类型");
        }
        return GsonUtil.toJsonStr(rs);
    }

    private void multiLogin(Channel channel) {
        // 发送警告
        BaseNettyMsg msg = new BaseNettyMsg();
        msg.setRqType(NettyMsgTypeEnmu.WARNNING.name());
        msg.setMsgContent("该账户已在其它地点登录");
        channel.writeAndFlush(GsonUtil.toJsonStr(msg));
        // 断开连接
        channel.disconnect();
    }
}
