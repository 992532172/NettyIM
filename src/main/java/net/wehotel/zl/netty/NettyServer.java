package net.wehotel.zl.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class NettyServer {
    private Logger logger = LoggerFactory.getLogger(NettyServer.class);

    public void initNettServer(int port) {
        // 配置服务端NIO线程组
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)// 一个用于服务端接收客户端的连接，另一个用于SocketChannel的网络读写
                    .channel(NioServerSocketChannel.class)// 传入SocketChannel
                    .option(ChannelOption.SO_BACKLOG, 1024)// 配置NioServerSocketChannel的TCP参数
                    .childHandler(new SimpleChatServerInitializer());// 绑定消息处理器

            b.bind(port).channel().closeFuture().sync();// 阻塞,直到serverSocketChannel关闭
        } catch (Exception e) {
            logger.error("NettyTimeServer异常中断:",e);
        } finally {
            // 优雅地关闭线程组
            bossGroup.shutdownGracefully();  
            workerGroup.shutdownGracefully();
        }
    }
}
