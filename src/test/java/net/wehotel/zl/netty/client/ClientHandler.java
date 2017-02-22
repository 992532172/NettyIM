package net.wehotel.zl.netty.client;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;

import java.net.SocketAddress;

import net.wehotel.zl.api.domain.ChatMsgDomain;
import net.wehotel.zl.api.request.BaseNettyMsg;
import net.wehotel.zl.commen.NettyMsgTypeEnmu;
import net.wehotel.zl.util.GsonUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientHandler extends ChannelHandlerAdapter {
    private Logger logger = LoggerFactory.getLogger(ClientHandler.class);
    
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        // 读取收到的请求数据
        String body = (String) msg;
        logger.debug("服务器接收到消息:{}", body);
        
//        String rsMsg = nettyRequestDispatcher.dispatch(ctx, body);
//        
//        if(StringUtils.isNotBlank(rsMsg)){
//            // 将响应消息写入缓冲区,等待发送
//            ctx.write(rsMsg);
//        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable e) throws Exception {
        ctx.close();
        logger.error("服务器捕捉到异常, 关闭会话", e);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        // 为避免频繁唤醒selector进行消息发送,在消息准备好将要发送的时候调用flush将缓冲区的消息全部写到SelectorChannel中
        logger.info("channelReadComplet");
        ctx.flush();
    }
    
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        BaseNettyMsg msg = new BaseNettyMsg();
        msg.setRqType(NettyMsgTypeEnmu.SIMPLE_CHAT.name());
        ChatMsgDomain domain = new ChatMsgDomain();
        domain.setMsgtype(ChatMsgDomain.SIMPLE_CHAT);
        domain.setSenderid("1");
        domain.setReceiverid("2");
        domain.setSpeakerid("1");
        domain.setMsgcontent("hello");
        msg.setMsgContent(GsonUtil.toJsonStr(domain));
//        ctx.channel().writeAndFlush(msg);
        logger.info("channelActive, remoteAddress:{}", ctx.channel().remoteAddress());
    }
    
    @Override
    public void connect(ChannelHandlerContext ctx, SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise) throws Exception {
        super.connect(ctx, remoteAddress, localAddress, promise);
        logger.info("connect:{}", remoteAddress);
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        super.channelRegistered(ctx);
        logger.info("register");
    }
    
}
