/**
 * =============================================================
 * Copyright 2018 Lianjia Group All Rights Reserved
 * CompanyName: 上海链家有限公司
 * SystemName: 贝壳
 * ClassName: NioTest2
 * version: 1.0.0
 * date: 2018/9/18
 * author: Tyson
 * =============================================================
 */
package com.tjq.netty.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Tyson
 * @version V1.0
 * @Description: TODO
 * @date 2018/9/18下午3:19
 */
public class NioTest2 {
    public static void main(String[] args) throws Exception {

        FileInputStream fileInputStream = new FileInputStream("");
        FileChannel channel = fileInputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        channel.read(byteBuffer);
        byteBuffer.flip();

        while (byteBuffer.remaining() > 0) {
            byte b = byteBuffer.get();
            System.out.println("cahar" + (char) b);
        }
        fileInputStream.close();
    }
}
