/**
 * =============================================================
 * Copyright 2018 Lianjia Group All Rights Reserved
 * CompanyName: 上海链家有限公司
 * SystemName: 贝壳
 * ClassName: MyPersonDecoder
 * version: 1.0.0
 * date: 2018/11/2
 * author: Tyson
 * =============================================================
 */
package com.tjq.netty.handle2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 *
 * @Description: TODO
 * @author Tyson
 * @date 2018/11/2上午11:27
 * @version V1.0
 */
public class MyPersonDecoder extends ReplayingDecoder<Void> {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("MyPersonDecoder decode invoked");

        byte[] content = new byte[in.readableBytes()];
        in.readBytes(content);

        PersonProtocol personProtocol = new PersonProtocol();
        personProtocol.setContent(content);
        personProtocol.setLength(in.readableBytes());

        out.add(personProtocol);

    }
}
