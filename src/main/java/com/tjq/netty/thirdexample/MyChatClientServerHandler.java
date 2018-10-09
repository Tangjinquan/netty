package com.tjq.netty.thirdexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 *
 * @Description: 服务器端与客户端的一对多的连接
 * @author tangjinquan
 * @date 2017/11/10下午2:19
 * @version V1.0
 */
public class MyChatClientServerHandler extends SimpleChannelInboundHandler<String>{


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(msg);
    }
}
