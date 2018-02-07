/**
 * =============================================================
 * Copyright 2017 ELE.ME All Rights Reserved
 * 公司名称: 拉扎斯网络科技（上海）有限公司
 * 系统名称: 代理商
 * 子系统名:
 * 模块名称:
 * 类   名: JodaTest
 * 概要:
 * 版本			日期				作者						备注
 * 1.0.0		2018/2/7	       Tyson	               初次做成
 * =============================================================
 */
package com.tjq.netty.date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author Tyson
 * @version V1.0
 * @Description: TODO
 * @date 2018/2/7下午2:55
 */
public class JodaTest {

    //标准UTC时间 ： 2014-11-04T09:22:21.876Z
    public static Date convertUTCDate(String utcDate) {
        try {
            DateTime parse = DateTime.parse(utcDate, DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ"));
            return parse.toDate();
        } catch (Exception e) {
            return null;
        }
    }

    public static String convertDate2UTC(Date javaDate) {
        DateTime dateTime = new DateTime(javaDate, DateTimeZone.UTC);
        return dateTime.toString();
    }

    public static String convertDate2LocalByDate(Date javaDate, String dateFormat) {
        DateTime dateTime = new DateTime(javaDate);
        return dateTime.toString(dateFormat);
    }

    public static void main(String[] args) {
        System.out.println(JodaTest.convertUTCDate("2014-11-04T09:22:21.876Z"));
        System.out.println(JodaTest.convertDate2UTC(new Date()));
        System.out.println(JodaTest.convertDate2LocalByDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
    }

}
