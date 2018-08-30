/**
 * =============================================================
 * Copyright 2018 Lianjia Group All Rights Reserved
 * CompanyName: 上海链家有限公司
 * SystemName: 贝壳
 * ClassName: TestServer
 * version: 1.0.0
 * date: 2018/8/29
 * author: Tyson
 * =============================================================
 */
package com.tjq.netty.sixthexample;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.net.InetSocketAddress;

/**
 * @author Tyson
 * @version V1.0
 * @Description: TODO
 * @date 2018/8/29下午2:54
 */
public class TestServer {

    public static void main(String[] args) throws Exception {
        NioEventLoopGroup boosGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(boosGroup, workerGroup).channel(NioServerSocketChannel.class).handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new TestServerInitializer());
            ChannelFuture channelFuture = serverBootstrap.bind(new InetSocketAddress(8899)).sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            boosGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }
}
