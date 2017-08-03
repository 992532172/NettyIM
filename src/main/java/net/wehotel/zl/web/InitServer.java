package net.wehotel.zl.web;

import javax.servlet.ServletException;

import net.wehotel.zl.netty.factory.NettyServerStarter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InitServer {
    private Logger logger = LoggerFactory.getLogger(InitServer.class);
    private NettyServerStarter nettyServerStarter;

    public void init() throws ServletException {
        try {
            nettyServerStarter.createServer();
        } catch (Exception e){
            logger.error("Netty服务异常", e);
        }
    }

    public void destroy() {
        nettyServerStarter.close();
    }
}
