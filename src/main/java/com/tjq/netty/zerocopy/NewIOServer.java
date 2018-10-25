/**
 * =============================================================
 * Copyright 2018 Lianjia Group All Rights Reserved
 * CompanyName: 上海链家有限公司
 * SystemName: 贝壳
 * ClassName: NewIOServer
 * version: 1.0.0
 * date: 2018/10/10
 * author: Tyson
 * =============================================================
 */
package com.tjq.netty.zerocopy;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author Tyson
 * @version V1.0
 * @Description: TODO
 * @date 2018/10/10下午4:59
 */
public class NewIOServer {
    public static void main(String[] args) throws Exception {
        InetSocketAddress inetSocketAddress = new InetSocketAddress(8899);
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.setReuseAddress(true);
        serverSocket.bind(inetSocketAddress);

        ByteBuffer allocate = ByteBuffer.allocate(4096);
        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(true);
            int readCount = 0;

            while (-1 != readCount) {
                try {
                    readCount = socketChannel.read(allocate);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                allocate.rewind();
            }
        }
    }
}
