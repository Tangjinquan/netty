/**
 * =============================================================
 * Copyright 2017 ELE.ME All Rights Reserved
 * 公司名称: 拉扎斯网络科技（上海）有限公司
 * 系统名称: 代理商
 * 子系统名:
 * 模块名称:
 * 类   名: DeclareQueue
 * 概要:
 * 版本			日期				作者						备注
 * 1.0.0		2018/2/3	       Tyson	               初次做成
 * =============================================================
 */
package com.tjq.netty.mq;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class DeclareQueue {
    public static String EXCHANGE_NAME = "notifyExchange";

    public static void init() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setPort(5672);

        Connection connection = null;
        try {
            connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);
            String routingKey = "AliPaynotify";
            String message = "http://localhost:8080/BossCenter/payGateway/notifyRecv.jsp?is_success=T¬ify_id=4ab9bed148d043d0bf75460706f7774a¬ify_time=2014-08-29+16%3A22%3A02¬ify_type=trade_status_sync&out_trade_no=1421712120109862&total_fee=424.42&trade_no=14217121201098611&trade_status=TRADE_SUCCESS";
            channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes());
            System.out.println(" [x] Sent :" + message);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception ignore) {
                }
            }
        }
    }

    public static void main(String args[]) {
        init();
    }

}