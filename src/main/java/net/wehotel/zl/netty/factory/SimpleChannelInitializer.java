package net.wehotel.zl.netty.factory;

import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOutboundHandler;
import io.netty.channel.socket.SocketChannel;

/**
 * channel初始化
 * 
 * @author Liang.Zhang
 * @date 2017年2月16日 下午6:11:50
 */
public class SimpleChannelInitializer extends ChannelInitializer<SocketChannel> {
    private ChannelInboundHandler msgHandler;// 消息监听器
    private ChannelInboundHandler msgDecoder;// 消息解码器
    private ChannelOutboundHandler msgEncoder;// 消息编码器

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        // 绑定编解码器和消息处理器
        socketChannel.pipeline().addLast("decoder", msgDecoder).addLast("encoder", msgEncoder).addLast("msgHandler", msgHandler);
    }

    public ChannelInboundHandler getMsgHandler() {
        return msgHandler;
    }

    public void setMsgHandler(ChannelInboundHandler msgHandler) {
        this.msgHandler = msgHandler;
    }

    public ChannelInboundHandler getMsgDecoder() {
        return msgDecoder;
    }

    public void setMsgDecoder(ChannelInboundHandler msgDecoder) {
        this.msgDecoder = msgDecoder;
    }

    public ChannelOutboundHandler getMsgEncoder() {
        return msgEncoder;
    }

    public void setMsgEncoder(ChannelOutboundHandler msgEncoder) {
        this.msgEncoder = msgEncoder;
    }

}
