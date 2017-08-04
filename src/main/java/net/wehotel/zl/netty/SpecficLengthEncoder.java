package net.wehotel.zl.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * 通过消息头指定消息长度的编码器
 * 
 * @author Liang.Zhang
 * @date 2017年2月17日 上午10:30:54
 */
public class SpecficLengthEncoder extends MessageToByteEncoder<String> {

    @Override
    protected void encode(ChannelHandlerContext ctx, String msg, ByteBuf buffer) throws Exception {
        byte[] data = msg.getBytes(ConstNetty.UTF8);
        buffer.writeInt(data.length);// 写入消息长度
        buffer.writeBytes(data);// 写入消息
    }

}
