package net.wehotel.zl.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import net.wehotel.zl.netty.server.NettyMsgHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * channel初始化
 * 
 * @author Liang.Zhang
 * @date 2017年2月16日 下午6:11:50
 */
@Component
public class SimpleChatServerInitializer extends ChannelInitializer<SocketChannel> {
    @Autowired
    private NettyMsgHandler nettyMsgHandler;
    
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        // 绑定编解码器和消息处理器
        socketChannel.pipeline().addLast("decoder", new SpecficLengthDecoder()).addLast("encoder", new SpecficLengthEncoder())
                .addLast("msgHandler", nettyMsgHandler);
    }

}
