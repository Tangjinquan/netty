/**
 * =============================================================
 * Copyright 2018 Lianjia Group All Rights Reserved
 * CompanyName: 上海链家有限公司
 * SystemName: 贝壳
 * ClassName: TestServerHandler
 * version: 1.0.0
 * date: 2018/8/29
 * author: Tyson
 * =============================================================
 */
package com.tjq.netty.sixthexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author Tyson
 * @version V1.0
 * @Description: TODO
 * @date 2018/8/29下午2:59
 */
public class TestServerHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMesssage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.MyMesssage msg) throws Exception {
        MyDataInfo.MyMesssage.Datatype datatype = msg.getDataType();
        if (datatype == MyDataInfo.MyMesssage.Datatype.PersonType) {
            MyDataInfo.Person person = msg.getPerson();
            System.out.println(person.getName());
            System.out.println(person.getAge());
            System.out.println(person.getAddress());
        } else if (datatype == MyDataInfo.MyMesssage.Datatype.DogType) {
            MyDataInfo.Dog dog = msg.getDog();
            System.out.println(dog.getName());
            System.out.println(dog.getAge());
        } else {
            MyDataInfo.Cat cat = msg.getCat();
            System.out.println(cat.getName());
            System.out.println(cat.getCity());
        }
    }
}
