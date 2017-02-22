package net.wehotel.zl.netty;

import io.netty.util.CharsetUtil;

import java.nio.charset.Charset;

/**
 * Netty服务器用到的静态常量
 * 
 * @author Liang.Zhang
 * @date 2017年2月17日 上午10:36:09
 */
public class ConstNetty {
    public static Charset UTF8 = CharsetUtil.UTF_8;// 默认编码
    
    public static int HEAD_SIZE = 4;// 消息头大小,消息头是一个int值,占4位

    public static int NETTY_PORT = 9090;// netty服务器监听接口
    
}
