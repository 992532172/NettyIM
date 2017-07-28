package net.wehotel.zl.util;

import io.netty.channel.Channel;
import net.wehotel.zl.api.request.BaseNettyMsg;
import net.wehotel.zl.commen.NettyMsgTypeEnmu;

/**
 * Created by liang.zhang on 2017/7/28.
 */
public class NettyMsgSendUtil {

    public static void sendNettyMsg(Channel client, String rqType, String msg){
        BaseNettyMsg baseNettyMsg = new BaseNettyMsg();
        baseNettyMsg.setMsgContent(msg);
        baseNettyMsg.setRqType(NettyMsgTypeEnmu.SIMPLE_CHAT_MSG_LIST.name());
        client.writeAndFlush(msg);
    }
}
