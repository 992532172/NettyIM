package net.wehotel.zl.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import net.wehotel.zl.netty.factory.ConnectionFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class InitServer extends HttpServlet {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Logger logger = LoggerFactory.getLogger(InitServer.class);

    @Override
    public void init() throws ServletException {
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
