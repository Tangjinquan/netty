/**
 * =============================================================
 * Copyright 2019 Lianjia Group All Rights Reserved
 * ClassName: DemoTest
 * version: 1.0.0
 * date: 2019/5/14
 * author: Tyson
 * =============================================================
 */
package com.tjq.netty.demotest;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.concurrent.*;

/**
 * @author Tyson
 * @version V1.0
 * @Description: TODO
 * @date 2019/5/14下午3:36
 */
public class DemoTest {


    private static final ExecutorService waitForExecutor = ExecutorUtils.createExecutorService(5, new LinkedBlockingQueue<>(100), "waitForExecutor");

//    public static void main(String[] args) {
//        String key = new String("ss");
//        int h = key.hashCode();
//        int a = h ^ (h >>> 16);
//    }


    public static void main(String[] args) {
        String commandStr ="/Users/tangjinquan/software/ffmpeg/bin/ffmpeg -i /Users/tangjinquan/Desktop/video/simple.mp4 -b:v 480k -s 320x640 /Users/tangjinquan/Desktop/woxiang/simple.mp4";
//        String commandStr ="ifconfig";   which ffmpeg
        BufferedReader br = null ;
        try {
            File file = new File("/Users/tangjinquan/Desktop/woxiang/simple.mp4");
            if (!file.getParentFile().exists()) { // 如果父目录不存在，创建父目录
                file.getParentFile().mkdirs();
            }
            if (file.exists()) { // 如果已存在,删除旧文件
                file.delete();
            }
            file.createNewFile();
            file.delete();

            Process p = Runtime.getRuntime().exec(commandStr);
            new StreamGobbler(p.getInputStream(), "Output").start();
            new StreamGobbler(p.getErrorStream(), "Error").start();

            Callable<Integer> call = new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    p.waitFor();
                    return p.exitValue();
                }
            };
            Future<Integer> submit = waitForExecutor.submit(call);
            Integer exitVal = submit.get(300, TimeUnit.SECONDS);

//            int exitVal = p.waitFor();
            if (exitVal != 0) {
                throw new Exception("waitFor has a exception 压缩失败");
            }
            p.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
