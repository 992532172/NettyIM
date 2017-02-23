package net.wehotel.zl.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NettyServer {
    private Logger logger = LoggerFactory.getLogger(NettyServer.class);

    @Autowired
    private SimpleChatServerInitializer simpleChatServerInitializer;

    public void initNettServer(int port) {
        // 配置服务端NIO线程组
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup);// 一个用于服务端接收客户端的连接，另一个用于SocketChannel的网络读写
            b.channel(NioServerSocketChannel.class);// 传入SocketChannel
            b.option(ChannelOption.SO_BACKLOG, 1024);// serverSocketchannel的设置，链接缓冲池的大小
            b.childOption(ChannelOption.SO_KEEPALIVE, true);// socketchannel的设置,维持链接的活跃，清除死链接
            b.childOption(ChannelOption.TCP_NODELAY, true);// socketchannel的设置,关闭延迟发送
            b.childHandler(simpleChatServerInitializer);// 绑定消息处理器
            ChannelFuture channelFuture = b.bind(port).sync();// 阻塞,知道netty服务器启动完成
            logger.info("Netty服务启动成功,port:{}", port);
            
            channelFuture.channel().closeFuture().sync();// 阻塞,直到serverSocketChannel关闭
        } catch (Exception e) {
            logger.error("NettyTimeServer异常中断:", e);
        } finally {
            // 优雅地关闭线程组
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
