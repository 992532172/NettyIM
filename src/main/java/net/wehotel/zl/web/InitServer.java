package net.wehotel.zl.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import net.wehotel.zl.netty.ConstNetty;
import net.wehotel.zl.netty.server.NettyServer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class InitServer extends HttpServlet {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Logger logger = LoggerFactory.getLogger(InitServer.class);
    @Autowired
    private NettyServer nettyServer;
    
    @Override
    public void init() throws ServletException {
        logger.info(">>> Start Init service");
        nettyServer.initNettServer(ConstNetty.NETTY_PORT);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
