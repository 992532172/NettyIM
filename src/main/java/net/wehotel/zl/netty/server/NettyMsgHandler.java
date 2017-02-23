package net.wehotel.zl.netty.server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;
import net.wehotel.zl.service.ClientStatusService;
import net.wehotel.zl.service.NettyRequestDispatcher;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Sharable
public class NettyMsgHandler extends ChannelInboundHandlerAdapter {
    private Logger logger = LoggerFactory.getLogger(NettyMsgHandler.class);

    @Autowired
    private NettyRequestDispatcher nettyRequestDispatcher;
    @Autowired
    private ClientStatusService clientStatusService;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        // 读取收到的请求数据
        String body = (String) msg;
        logger.debug("channelRead服务器接收到消息:{}", body);

        String rsMsg = nettyRequestDispatcher.dispatch(ctx, body);

        if (StringUtils.isNotBlank(rsMsg)) {
            // 将响应消息写入缓冲区,等待发送
            ctx.write(rsMsg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable e) throws Exception {
        ctx.close();
        logger.error("服务器捕捉到异常, 关闭会话", e);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        // 为避免频繁唤醒selector进行消息发送,在消息准备好将要发送的时候调用flush将缓冲区的消息全部写到SelectorChannel中
        ctx.flush();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        logger.debug("channelActive, ctx:{}", ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        logger.debug("channelInactive");
        clientStatusService.removeClient(ctx.channel());
        ctx.channel().closeFuture();
        super.channelInactive(ctx);
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        Channel channel = ctx.channel();
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent idleStateEvent = (IdleStateEvent) evt;
            if (idleStateEvent.state().equals(IdleStateEvent.ALL_IDLE_STATE_EVENT)) {
                channel.closeFuture();
            }
        }
    }

}
