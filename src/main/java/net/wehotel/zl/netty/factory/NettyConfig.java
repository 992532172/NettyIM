package net.wehotel.zl.netty.factory;

import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.ChannelOutboundHandler;
import net.wehotel.zl.netty.SpecficLengthDecoder;
import net.wehotel.zl.netty.SpecficLengthEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;

public class NettyConfig {
    private Logger logger = LoggerFactory.getLogger(NettyConfig.class);
    private Integer port = null;
    private ChannelInboundHandler childHandler;
    private ChannelInboundHandler msgHandler;
    private ChannelOutboundHandler msgEncoder;
    private ChannelInboundHandler msgDecoder;

    @PostConstruct
    private void initConfig() {
        if (port == null || port == 0) {
            port = 9990;
            logger.debug("未配置监听端口,默认使用{}", port);
        }
        if (childHandler == null) {// 默认childhandler
            logger.debug("未配置childHandler,使用默认的net.wehotel.zl.netty.factory.SimpleChannelInitializer");
            childHandler = new SimpleChannelInitializer();
        }
        if (msgEncoder == null) {// 默认编码器（自定义指定长度的消息编码器）
            logger.debug("未配置消息编码器,使用默认的net.wehotel.zl.netty.SpecficLengthEncoder");
            msgEncoder = new SpecficLengthEncoder();
        }
        if (msgDecoder == null) {// 默认解码器（自定义指定长度的消息解码器）
            logger.debug("未配置消息解码器,使用默认的net.wehotel.zl.netty.SpecficLengthDecoder");
            msgDecoder = new SpecficLengthDecoder();
        }
        if (msgHandler == null) {// 必须绑定一个消息处理器
            throw new NullPointerException("msgHandler is null!");
        }
    }

    public ChannelInboundHandler getChildHandler() {
        return childHandler;
    }

    public void setChildHandler(ChannelInboundHandler childHandler) {
        this.childHandler = childHandler;
    }

    public ChannelInboundHandler getMsgHandler() {
        return msgHandler;
    }

    public void setMsgHandler(ChannelInboundHandler msgHandler) {
        this.msgHandler = msgHandler;
    }

    public ChannelOutboundHandler getMsgEncoder() {
        return msgEncoder;
    }

    public void setMsgEncoder(ChannelOutboundHandler msgEncoder) {
        this.msgEncoder = msgEncoder;
    }

    public ChannelInboundHandler getMsgDecoder() {
        return msgDecoder;
    }

    public void setMsgDecoder(ChannelInboundHandler msgDecoder) {
        this.msgDecoder = msgDecoder;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

}
