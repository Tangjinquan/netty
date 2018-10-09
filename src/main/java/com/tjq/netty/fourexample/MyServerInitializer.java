package com.tjq.netty.fourexample;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 *
 * @Description: 心跳检测
 * @author tangjinquan
 * @date 2017/11/10下午2:36
 * @version V1.0
 */
public class MyServerInitializer extends ChannelInitializer<SocketChannel>{
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new IdleStateHandler(5, 4, 10, TimeUnit.SECONDS));
        pipeline.addLast(new MyServerHandler());
    }
}
