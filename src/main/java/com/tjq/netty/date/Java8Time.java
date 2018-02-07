/**
 * =============================================================
 * Copyright 2017 ELE.ME All Rights Reserved
 * 公司名称: 拉扎斯网络科技（上海）有限公司
 * 系统名称: 代理商
 * 子系统名:
 * 模块名称:
 * 类   名: Java8Time
 * 概要:
 * 版本			日期				作者						备注
 * 1.0.0		2018/2/7	       Tyson	               初次做成
 * =============================================================
 */
package com.tjq.netty.date;


import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Tyson
 * @version V1.0
 * @Description: TODO
 * @date 2018/2/7下午3:13
 */
public class Java8Time {

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println(now);

        System.out.println(now.getYear() + "," + now.getMonthValue() + "," + now.getDayOfMonth());


        LocalDate of = LocalDate.of(2017, 3, 3);
        System.out.println(of);

        //比较当前时间
        LocalDate localDate = LocalDate.of(2010, 3, 25);
        MonthDay monthDay = MonthDay.of(localDate.getMonth(), localDate.getDayOfMonth());
        MonthDay monthDay1 = MonthDay.from(localDate.of(2011, 3, 25));
        if (monthDay.equals(monthDay1)) {
            System.out.println("equal");
        } else {
            System.out.println("no equal");
        }

        //时分秒 重要
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        LocalTime localTime1 = localTime.plusHours(3).plusMinutes(20);
        System.out.println(localTime1);

        LocalDate plus = localDate.plus(2, ChronoUnit.WEEKS);
        System.out.println(plus);

        LocalDate minus = localDate.minus(2, ChronoUnit.MONTHS);
        System.out.println(minus);

        Clock clock = Clock.systemDefaultZone();
        System.out.println(clock.millis());

        LocalDate now1 = LocalDate.now();
        LocalDate of1 = LocalDate.of(2018, 2, 7);
        System.out.println(now1.isBefore(of1));
        System.out.println(now1.isAfter(of1));
        System.out.println(now1.equals(of1));

        //时区
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        TreeSet<String> treeSet = new TreeSet<String>() {
            {
                addAll(availableZoneIds);
            }
        };
        System.out.println(treeSet);
        availableZoneIds.stream().forEach(System.out::println);

        ZoneId of2 = ZoneId.of("Asia/Shanghai");
        LocalDateTime now2 = LocalDateTime.now();
        System.out.println(now2);
        ZonedDateTime of3 = ZonedDateTime.of(now2, of2);
        System.out.println(of3);

        YearMonth yearMonth = YearMonth.now();
        System.out.println(yearMonth);
        System.out.println(yearMonth.lengthOfMonth());
        System.out.println(yearMonth.isLeapYear());


        YearMonth yearMonth1 = YearMonth.of(2018, 2);
        System.out.println(yearMonth1);
        System.out.println(yearMonth1.lengthOfMonth());
        System.out.println(yearMonth1.lengthOfYear());
        System.out.println(yearMonth1.isLeapYear());


        //算出间隔
        LocalDate LocalDate1 = LocalDate.now();
        LocalDate LocalDate2 = LocalDate.of(2018, 2, 2);
        Period between = Period.between(LocalDate1, LocalDate2);
        System.out.println(between.getMonths());
        System.out.println(between.getDays());
        System.out.println(between.getYears());

    }
}
