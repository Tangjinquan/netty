package com.tjq.netty.thirdexample;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @Description: TODO
 * @author tangjinquan
 * @date 2017/11/10下午2:15
 * @version V1.0
 */
public class MyChatClient {
    public static void main(String[] args) throws Exception {
        NioEventLoopGroup eventGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        try {
            bootstrap.group(eventGroup).channel(NioSocketChannel.class).handler(new MyChatClientInitializer());
            Channel channel = bootstrap.connect("localhost", 8899).sync().channel();

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            for (; ; ) {
                channel.writeAndFlush(br.readLine() + "\r\n");
            }

        } finally {
            eventGroup.shutdownGracefully();
        }
    }
}
