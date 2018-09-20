/**
 * =============================================================
 * Copyright 2018 Lianjia Group All Rights Reserved
 * CompanyName: 上海链家有限公司
 * SystemName: 贝壳
 * ClassName: NioTest4
 * version: 1.0.0
 * date: 2018/9/18
 * author: Tyson
 * =============================================================
 */
package com.tjq.netty.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Tyson
 * @version V1.0
 * @Description: TODO
 * @date 2018/9/18下午6:07
 */
public class NioTest4 {

    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("input.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("output.txt");

        FileChannel inChannel = fileInputStream.getChannel();
        FileChannel outChannel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        while (true) {
            byteBuffer.clear();
            int read = inChannel.read(byteBuffer);
            System.out.println("read" + read);
            if (read == -1) {
                break;
            }
            byteBuffer.flip();
            outChannel.write(byteBuffer);
        }
        inChannel.close();
        outChannel.close();
    }
}
