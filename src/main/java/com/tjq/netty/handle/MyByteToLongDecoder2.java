/**
 * =============================================================
 * Copyright 2018 Lianjia Group All Rights Reserved
 * CompanyName: 上海链家有限公司
 * SystemName: 贝壳
 * ClassName: MyByteToLongDecoder2
 * version: 1.0.0
 * date: 2018/11/1
 * author: Tyson
 * =============================================================
 */
package com.tjq.netty.handle;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 *
 * @Description: TODO
 * @author Tyson
 * @date 2018/11/1下午3:27
 * @version V1.0
 */
public class MyByteToLongDecoder2 extends ReplayingDecoder<Void> {


    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("MyByteToLongDecoder2 decode invoked");
        out.add(in.readLong());
    }
}
