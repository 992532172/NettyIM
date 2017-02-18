package net.wehotel.zl.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import net.wehotel.zl.netty.ConstNetty;
import net.wehotel.zl.netty.NettyServer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InitServer extends HttpServlet {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Logger logger = LoggerFactory.getLogger(InitServer.class);
    
    private NettyServer nettyTimeServer;
    
    @Override
    public void init() throws ServletException {
        logger.info(">>> Start Init service");
        nettyTimeServer.initNettServer(ConstNetty.NETTY_PORT);
        logger.info("service Start >>>>>>>>>>");
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
