/**
 * =============================================================
 * Copyright 2018 Lianjia Group All Rights Reserved
 * CompanyName: 上海链家有限公司
 * SystemName: 贝壳
 * ClassName: MyLongToByteEncoder
 * version: 1.0.0
 * date: 2018/11/1
 * author: Tyson
 * =============================================================
 */
package com.tjq.netty.handle;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.MessageToByteEncoder;


/**
 *
 * @Description: TODO
 * @author Tyson
 * @date 2018/11/1下午2:08
 * @version V1.0
 */
public class MyLongToByteEncoder extends MessageToByteEncoder<Long> {

    @Override
    protected void encode(ChannelHandlerContext ctx, Long msg, ByteBuf out) throws Exception {
        System.out.println("encode invoke");

        System.out.println(msg);

        out.writeLong(msg);
    }
}
