package com.tjq.netty.secondexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.UUID;

/**
 *
 * @Description: TODO
 * @author tangjinquan
 * @date 2017/10/31上午10:13
 * @version V1.0
 */
public class MyServerHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + "," + msg);
        ctx.writeAndFlush("from server" + UUID.randomUUID());
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}