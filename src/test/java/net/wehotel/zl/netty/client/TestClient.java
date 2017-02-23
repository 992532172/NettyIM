package net.wehotel.zl.netty.client;

import net.wehotel.zl.api.domain.ChatMsgDomain;
import net.wehotel.zl.api.domain.UserDomain;
import net.wehotel.zl.api.request.BaseNettyMsg;
import net.wehotel.zl.commen.NettyMsgTypeEnmu;
import net.wehotel.zl.util.GsonUtil;

import org.junit.Test;

public class TestClient {

    @Test
    public void test() {
        String msg = getLoginMsg();
        NettyClient.initNettServer(msg);
    }
    
    
    private static String getChatMsg() {
        BaseNettyMsg msg = new BaseNettyMsg();
        msg.setRqType(NettyMsgTypeEnmu.SIMPLE_CHAT.name());
        ChatMsgDomain domain = new ChatMsgDomain();
        domain.setMsgtype(ChatMsgDomain.SIMPLE_CHAT);
        domain.setSenderid("1");
        domain.setReceiverid("1");
        domain.setSpeakerid("1");
        domain.setMsgcontent("hello");
        msg.setMsgContent(GsonUtil.toJsonStr(domain));
        return GsonUtil.toJsonStr(msg);
    }
    
    private static String getLoginMsg() {

        BaseNettyMsg msg = new BaseNettyMsg();
        msg.setRqType(NettyMsgTypeEnmu.LOGIN.name());
        UserDomain domain = new UserDomain();
        domain.setUsername("testing");
        domain.setPassword("testing");
        msg.setMsgContent(GsonUtil.toJsonStr(domain));
        return GsonUtil.toJsonStr(msg);
    }
}
