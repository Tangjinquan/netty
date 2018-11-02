/**
 * =============================================================
 * Copyright 2018 Lianjia Group All Rights Reserved
 * CompanyName: 上海链家有限公司
 * SystemName: 贝壳
 * ClassName: ByteBufTest
 * version: 1.0.0
 * date: 2018/10/30
 * author: Tyson
 * =============================================================
 */
package com.tjq.netty.test;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 *
 * @Description: TODO
 * @author Tyson
 * @date 2018/10/30下午3:27
 * @version V1.0
 */
public class ByteBufTest {
    public static void main(String[] args) {
        ByteBuf buffer = Unpooled.buffer(10);
        for (int i = 0; i <10 ; i++) {
            buffer.writeByte(i);
        }
        System.out.println(buffer.capacity());
        for (int i = 0; i <buffer.capacity() ; i++) {
            //绝对访问
            System.out.println(buffer.getByte(i));
        }

        for (int i = 0; i <buffer.capacity() ; i++) {
            //相对访问
            System.out.println(buffer.readByte());
        }
    }
}
