/**
 * =============================================================
 * Copyright 2018 Lianjia Group All Rights Reserved
 * CompanyName: 上海链家有限公司
 * SystemName: 贝壳
 * ClassName: ByteBufTest2
 * version: 1.0.0
 * date: 2018/10/31
 * author: Tyson
 * =============================================================
 */
package com.tjq.netty.test;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;

import java.util.Iterator;

/**
 * @author Tyson
 * @version V1.0
 * @Description: TODO
 * @date 2018/10/31上午10:10
 */
public class ByteBufTest2 {
    public static void main(String[] args) {
        CompositeByteBuf compositeByteBuf = Unpooled.compositeBuffer();

        ByteBuf heapBuffer = Unpooled.buffer(10);
        ByteBuf directBuffer = Unpooled.directBuffer(8);
        System.out.println(heapBuffer);
        System.out.println(directBuffer);
        compositeByteBuf.addComponents(heapBuffer, directBuffer);
        compositeByteBuf.removeComponent(0);
        Iterator<ByteBuf> iterator = compositeByteBuf.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        compositeByteBuf.forEach(System.out::println);
    }
}
