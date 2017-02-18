package net.wehotel.zl.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * 通过消息头指定消息长度的解码器
 * 
 * @author Liang.Zhang
 * @date 2017年2月17日 上午9:41:18
 */
public class SpecficLengthDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if (in.readableBytes() < ConstNetty.HEAD_SIZE) {// 消息头是一个int值
            return;
        }
        in.markReaderIndex();// 记录位置
        int msgLength = in.readInt();// 取出指定的消息长度
        if (msgLength < 0) {// 消息长度小于0, 直接返回
            return;
        }

        if (in.readableBytes() < msgLength) {// 如果接收到的消息小于定义的消息长度
            in.resetReaderIndex();// 将游标重置到标记的位置
            return;
        }
        
        // 读取数据
        byte[] msgBytes = new byte[msgLength];
        in.readBytes(msgBytes);
        String msg = new String(msgBytes, ConstNetty.UTF8);
        out.add(msg);
    }

}
