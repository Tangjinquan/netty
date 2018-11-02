/**
 * =============================================================
 * Copyright 2018 Lianjia Group All Rights Reserved
 * CompanyName: 上海链家有限公司
 * SystemName: 贝壳
 * ClassName: MyPersonEncoder
 * version: 1.0.0
 * date: 2018/11/2
 * author: Tyson
 * =============================================================
 */
package com.tjq.netty.handle2;


import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 *
 * @Description: TODO
 * @author Tyson
 * @date 2018/11/2上午11:28
 * @version V1.0
 */
public class MyPersonEncoder  extends MessageToByteEncoder<PersonProtocol> {


    @Override
    protected void encode(ChannelHandlerContext ctx, PersonProtocol msg, ByteBuf out) throws Exception {
        System.out.println("MyPersonEncoder encode invoked");
        out.writeInt(msg.getLength());
        out.writeBytes(msg.getContent());
    }
}
