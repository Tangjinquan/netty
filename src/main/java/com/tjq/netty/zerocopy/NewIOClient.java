/**
 * =============================================================
 * Copyright 2018 Lianjia Group All Rights Reserved
 * CompanyName: 上海链家有限公司
 * SystemName: 贝壳
 * ClassName: NewIOClient
 * version: 1.0.0
 * date: 2018/10/10
 * author: Tyson
 * =============================================================
 */
package com.tjq.netty.zerocopy;

import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * @author Tyson
 * @version V1.0
 * @Description: TODO
 * @date 2018/10/10下午5:13
 */
public class NewIOClient {
    public static void main(String[] args) throws Exception {

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress(8899));
        socketChannel.configureBlocking(true);
        String filename = "/Users/tangjinquan/Desktop/SpringBoot_v2";
        FileChannel channel = new FileInputStream(filename).getChannel();
        long startTime = System.currentTimeMillis();
        long transferCount = channel.transferTo(0, channel.size(), socketChannel);
        System.out.println("发送总字节数 " + transferCount + "耗时 " + (System.currentTimeMillis() - startTime));
        channel.close();
    }
}
