package net.wehotel.zl.netty.factory;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * netty服务启动器
 * Created by liang.zhang on 2017/8/1.
 */
public class NettyServerStarter {
    private Logger logger = LoggerFactory.getLogger(NettyServerStarter.class);

    private NettyConfig nettyConfig;
    private EventLoopGroup bossGroup;
    private EventLoopGroup workerGroup;

    public void createServer() throws InterruptedException {
        nettyConfig.initConfig();
        createTcpServer();
    }

    public void close() {
        if (bossGroup != null) bossGroup.shutdownGracefully();
        if (workerGroup != null) workerGroup.shutdownGracefully();
    }

    /**
     * 创建一个TCP连接
     *
     * @return
     * @throws InterruptedException
     */
    private void createTcpServer() throws InterruptedException {
        bossGroup = new NioEventLoopGroup();
        workerGroup = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup, workerGroup);// 绑定事件组
        serverBootstrap.channel(NioServerSocketChannel.class);// 绑定基于NIO的socketChannel
        serverBootstrap.childHandler(nettyConfig.getChildHandler());// 绑定childhandler
        ChannelFuture channelFuture = serverBootstrap.bind(nettyConfig.getPort()).sync();// 绑定端口启动服务并阻塞,等待连接
        logger.info("netty服务启动成功,port:{}", nettyConfig.getPort());
    }

    public NettyConfig getNettyConfig() {
        return nettyConfig;
    }

    public void setNettyConfig(NettyConfig nettyConfig) {
        this.nettyConfig = nettyConfig;
    }

}
