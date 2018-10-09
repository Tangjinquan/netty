/**
 * =============================================================
 * Copyright 2018 Lianjia Group All Rights Reserved
 * CompanyName: 上海链家有限公司
 * SystemName: 贝壳
 * ClassName: TestClientHandler
 * version: 1.0.0
 * date: 2018/8/29
 * author: Tyson
 * =============================================================
 */
package com.tjq.netty.sixthexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

/**
 * @author Tyson
 * @version V1.0
 * @Description: 基于protobuf的编解码支持
 * @date 2018/8/29下午3:04
 */
public class TestClientHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMesssage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.MyMesssage msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        int randomInt = new Random().nextInt(3);
        MyDataInfo.MyMesssage myMesssage = null;
        if (0 == randomInt) {
            myMesssage = MyDataInfo.MyMesssage.newBuilder()
                    .setDataType(MyDataInfo.MyMesssage.Datatype.PersonType)
                    .setPerson(MyDataInfo.Person.newBuilder().setName("tangjin").setAge(23).setAddress("测试地址").build()).build();
        } else if (1 == randomInt) {
            myMesssage = MyDataInfo.MyMesssage.newBuilder()
                    .setDataType(MyDataInfo.MyMesssage.Datatype.DogType)
                    .setDog(MyDataInfo.Dog.newBuilder().setName("dog").setAge(2).build()).build();
        } else {
            myMesssage = MyDataInfo.MyMesssage.newBuilder()
                    .setDataType(MyDataInfo.MyMesssage.Datatype.CatType)
                    .setCat(MyDataInfo.Cat.newBuilder().setName("cat").setCity(444).build()).build();
        }
        ctx.channel().writeAndFlush(myMesssage);
    }
}
