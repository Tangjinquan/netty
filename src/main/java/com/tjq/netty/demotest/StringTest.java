/**
 * =============================================================
 * Copyright 2019 Lianjia Group All Rights Reserved
 * ClassName: StringTest
 * version: 1.0.0
 * date: 2019/6/11
 * author: Tyson
 * =============================================================
 */
package com.tjq.netty.demotest;

import com.google.common.collect.Sets;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * @author Tyson
 * @version V1.0
 * @Description: TODO
 * @date 2019/6/11上午11:38
 */
public class StringTest {

    public static void main(String[] args) {
//        String s  = "hf-bonusweb-7c577cd6c9-s4m2n";
//        List<String> split = Arrays.asList(s.split("-"));
//        String s1 = split.get(0);
//        String s2 = split.get(1);
//        System.out.println();
//
//        Set<String> wechats = Sets.newTreeSet();
//        String join = String.join(",", wechats);
//        System.out.println(join);
//
//        String default_wechat_list = "26021328,20365886,23113878";
//        String we = "";
//        List<String> defaultWechatList = Arrays.asList(default_wechat_list.split(","));
//        String[] split = we.split(",");
//        Arrays.stream(split).distinct().forEach(item ->{
//            String a = item;
//            System.out.println(item);
//        });
////        String[] both = (String[]) ArrayUtils.addAll(first, second);
////        String[] strings = new String[defaultWechatList.size() + wechatList.size()];
////        String[] all = defaultWechatList.toArray(strings);
//        System.out.println();
//        String owner = "jhjdh";
//        List<String> ownerList = Arrays.asList(owner.split(","));
//        System.out.println();
        File cos = null;
        try {
            cos = File.createTempFile("cos", ".tmp");
            throe();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cos.deleteOnExit();
//            cos.deleteOnExit();
        }

    }

    private static void throe() throws Exception {
        throw new Exception("中途断开");
    }
}
