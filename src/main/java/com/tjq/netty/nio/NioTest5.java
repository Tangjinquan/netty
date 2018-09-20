/**
 * =============================================================
 * Copyright 2018 Lianjia Group All Rights Reserved
 * CompanyName: 上海链家有限公司
 * SystemName: 贝壳
 * ClassName: NioTest5
 * version: 1.0.0
 * date: 2018/9/19
 * author: Tyson
 * =============================================================
 */
package com.tjq.netty.nio;

import java.nio.ByteBuffer;

/**
 *
 * @Description: TODO
 * @author Tyson
 * @date 2018/9/19上午11:36
 * @version V1.0
 */
public class NioTest5 {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(64);
        byteBuffer.putInt(15);
        byteBuffer.putLong(500000L);
        byteBuffer.putDouble(32.333);
        byteBuffer.putShort((short)(2));
        byteBuffer.putChar('我');
        byteBuffer.flip();

        System.out.println(byteBuffer.getInt());
        System.out.println(byteBuffer.getLong());
        System.out.println(byteBuffer.getDouble());
        System.out.println(byteBuffer.getShort());
        System.out.println(byteBuffer.getChar());

    }
}
