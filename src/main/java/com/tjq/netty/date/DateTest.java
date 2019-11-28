/**
 * =============================================================
 * Copyright 2017 ELE.ME All Rights Reserved
 * 公司名称: 拉扎斯网络科技（上海）有限公司
 * 系统名称: 代理商
 * 子系统名:
 * 模块名称:
 * 类   名: DateTest
 * 概要:
 * 版本			日期				作者						备注
 * 1.0.0		2018/2/6	       Tyson	               初次做成
 * =============================================================
 */
package com.tjq.netty.date;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import java.time.LocalDateTime;


/**
 * @author Tyson
 * @version V1.0
 * @Description: 日期相关 joda
 * @date 2018/2/6下午8:53
 */
public class DateTest {

    public static void main(String[] args) {


        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localDateTime = LocalDateTime.now().withHour(23).withMinute(59).withSecond(0);
        boolean after = now.isAfter(localDateTime);


        DateTime today = new DateTime();
        DateTime nextday = today.plusDays(1);
        System.out.println(today.toString("yyyy-MM-dd"));
        System.out.println(nextday.toString("yyyy-MM-dd"));

        DateTime dt1 = today.withDayOfMonth(1);
        System.out.println(dt1.toString("yyyy-MM-dd"));

        LocalDate localDate = new LocalDate();
        System.out.println(localDate);


        LocalDate localDate1 = localDate.plusMonths(3).dayOfMonth().withMaximumValue();
        LocalDate localDate2 = localDate.plusMonths(3).dayOfMonth().withMinimumValue();
        System.out.println(localDate1);
        System.out.println(localDate2);

        //计算两年前第3个月最后一天的日期
        DateTime dateTime = new DateTime();
        DateTime dateTime1 = dateTime.minusYears(2).monthOfYear().setCopy(3).dayOfMonth().withMinimumValue();
        System.out.println(dateTime1.toString("yyyy-MM-dd"));


    }
}
