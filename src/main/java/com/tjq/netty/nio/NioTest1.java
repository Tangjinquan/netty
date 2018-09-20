/**
 * =============================================================
 * Copyright 2018 Lianjia Group All Rights Reserved
 * CompanyName: 上海链家有限公司
 * SystemName: 贝壳
 * ClassName: NioTest1
 * version: 1.0.0
 * date: 2018/9/18
 * author: Tyson
 * =============================================================
 */
package com.tjq.netty.nio;

import java.nio.IntBuffer;
import java.security.SecureRandom;

/**
 * @author Tyson
 * @version V1.0
 * @Description: TODO
 * @date 2018/9/18下午2:51
 */
public class NioTest1 {
    public static void main(String[] args) {
        IntBuffer buffer = IntBuffer.allocate(10);
        for (int i = 0; i < buffer.capacity(); i++) {
            int randomNumber = new SecureRandom().nextInt(20);
            buffer.put(randomNumber);
        }
        buffer.flip();
        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }
        buffer.clear();
        while (buffer.hasRemaining()) {
            System.out.println("2  " + buffer.get());
        }
    }
}
