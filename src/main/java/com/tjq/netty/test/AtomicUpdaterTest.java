/**
 * =============================================================
 * Copyright 2018 Lianjia Group All Rights Reserved
 * CompanyName: 上海链家有限公司
 * SystemName: 贝壳
 * ClassName: AtomicUpdaterTest
 * version: 1.0.0
 * date: 2018/10/31
 * author: Tyson
 * =============================================================
 */
package com.tjq.netty.test;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @author Tyson
 * @version V1.0
 * @Description: TODO
 * @date 2018/10/31下午4:58
 */
public class AtomicUpdaterTest {

    public static void main(String[] args) {
//        Person person = new Person();
//        for (int i = 0; i < 10; i++) {
//            Thread thread = new Thread(() -> {
//                System.out.println(person.age++);
//            });
//        thread.start();
//        }

        Person person = new Person();
        AtomicIntegerFieldUpdater<Person> age = AtomicIntegerFieldUpdater.newUpdater(Person.class, "age");
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(20);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(age.getAndIncrement(person));
            });
            thread.start();
        }



    }
}

class Person {
    volatile int age = 1;
}
