package com.tjq.netty.secondexample;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.oio.OioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.channel.socket.oio.OioServerSocketChannel;

/**
 *
 * @Description: TODO
 * @author tangjinquan
 * @date 2017/10/31上午10:19
 * @version V1.0
 */
public class MyClient {
    public static void main(String[] args) throws Exception{
        NioEventLoopGroup eventGroup = new NioEventLoopGroup();     //OioEventLoopGroup
        Bootstrap bootstrap = new Bootstrap();
        try {
            bootstrap.group(eventGroup).channel(NioSocketChannel.class).handler(new MyClientInitializer()); // OioServerSocketChannel
            ChannelFuture channelFuture = bootstrap.connect("localhost", 8899).sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            eventGroup.shutdownGracefully();
        }
    }
}
