/**
 * =============================================================
 * Copyright 2018 Lianjia Group All Rights Reserved
 * CompanyName: 上海链家有限公司
 * SystemName: 贝壳
 * ClassName: TestClient
 * version: 1.0.0
 * date: 2018/8/29
 * author: Tyson
 * =============================================================
 */
package com.tjq.netty.sixthexample;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @Description: TODO
 * @author Tyson
 * @date 2018/8/29下午3:02
 * @version V1.0
 */
public class TestClient {
    public static void main(String[] args) throws Exception{
        NioEventLoopGroup eventGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        try {
            bootstrap.group(eventGroup).channel(NioSocketChannel.class).handler(new TestClientInitializer());
            ChannelFuture channelFuture = bootstrap.connect("localhost", 8899).sync();
            channelFuture.channel().closeFuture().sync();

        } finally {
            eventGroup.shutdownGracefully();
        }
    }
}
