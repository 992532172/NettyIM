package net.wehotel.zl.netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.SocketAddress;

import net.wehotel.zl.api.domain.ChatMsgDomain;
import net.wehotel.zl.api.request.BaseNettyMsg;
import net.wehotel.zl.commen.NettyMsgTypeEnmu;
import net.wehotel.zl.netty.ConstNetty;
import net.wehotel.zl.netty.SpecficLengthDecoder;
import net.wehotel.zl.netty.SpecficLengthEncoder;
import net.wehotel.zl.util.GsonUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NettyClient {
    private static Logger logger = LoggerFactory.getLogger(NettyClient.class);

    public static void main(String[] args) {
        initNettServer();

//        try {
//            Socket client = new Socket("127.0.0.1", ConstNetty.NETTY_PORT);
//            PrintWriter pw=new PrintWriter(client.getOutputStream());
//            pw.write(6);
//            pw.write("hello!");
//            pw.flush();
//            pw.close();
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
    }

    public static void initNettServer() {
        // 配置服务端NIO线程组
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(workerGroup)// 一个用于服务端接收客户端的连接，另一个用于SocketChannel的网络读写
                    .channel(NioSocketChannel.class)// 传入SocketChannel
                    .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 6000)
                    .handler(new ChannelInitializer<Channel>() {
                        @Override
                        public void initChannel(Channel ch) throws Exception {
                            ChannelPipeline p = ch.pipeline();

                            p.addLast("decoder", new SpecficLengthDecoder());
                            p.addLast("encoder", new SpecficLengthEncoder());
                            p.addLast(new ClientHandler());
                        }
                    });// 绑定消息处理器

            ChannelFuture future = b.connect("127.0.0.1", ConstNetty.NETTY_PORT).awaitUninterruptibly();
            logger.info("connect {}", future.isSuccess());
            if (future.isSuccess()) {
                Channel channel = future.channel();
                SocketAddress address = channel.remoteAddress();
                channel.writeAndFlush(getMsg());
            }
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            logger.error("NettyTimeServer异常中断:", e);
        } finally {
            // 优雅地关闭线程组
            workerGroup.shutdownGracefully();
        }
    }

    private static String getMsg() {

        BaseNettyMsg msg = new BaseNettyMsg();
        msg.setRqType(NettyMsgTypeEnmu.SIMPLE_CHAT.name());
        ChatMsgDomain domain = new ChatMsgDomain();
        domain.setMsgtype(ChatMsgDomain.SIMPLE_CHAT);
        domain.setSenderid("1");
        domain.setReceiverid("2");
        domain.setSpeakerid("1");
        domain.setMsgcontent("hello");
        msg.setMsgContent(GsonUtil.toJsonStr(domain));
        return GsonUtil.toJsonStr(msg);
    }
}
