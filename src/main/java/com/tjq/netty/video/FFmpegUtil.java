/**
 * =============================================================
 * Copyright 2018 Lianjia Group All Rights Reserved
 * CompanyName: 上海链家有限公司
 * SystemName: 贝壳
 * ClassName: FFmpegUtil
 * version: 1.0.0
 * date: 2018/10/11
 * author: Tyson
 * =============================================================
 */
package com.tjq.netty.video;


import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 *
 * @Description: TODO
 * @author Tyson
 * @date 2018/10/11下午5:08
 * @version V1.0
 */
public class FFmpegUtil {

    private final static String PATH = "c:\\ffmpeg\\input\\drf.avi";
    public static void main(String[] args) {
        if (!checkfile(PATH)) {
            System.out.println(PATH + " is not file");
            return;
        }
        File file = new File(PATH);
        String fileName = file.getName();

        fileName = fileName.substring(0, fileName.indexOf("."));// 处理文件名称（不含后缀名）

        if (process(fileName)) {
            System.out.println("ok");
        }
    }
    private static boolean process(String fileName) {
        int type = checkContentType();
        boolean status = false;
        if (type == 0) {
            System.out.println("直接将文件转为flv文件");
            status = processFLV(PATH,fileName);// 直接将文件转为flv文件
        } else if (type == 1) {
            String avifilepath = processAVI(type,fileName);
            if (avifilepath == null)
                return false;// avi文件没有得到
            status = processFLV(avifilepath,fileName);// 将avi转为flv
        }
        return status;
    }
    private static int checkContentType() {
        String type = PATH.substring(PATH.lastIndexOf(".") + 1, PATH.length())
                .toLowerCase();
        // ffmpeg能解析的格式：（asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv等）
        if (type.equals("avi")) {
            return 0;
        } else if (type.equals("mpg")) {
            return 0;
        } else if (type.equals("wmv")) {
            return 0;
        } else if (type.equals("3gp")) {
            return 0;
        } else if (type.equals("mov")) {
            return 0;
        } else if (type.equals("mp4")) {
            return 0;
        } else if (type.equals("asf")) {
            return 0;
        } else if (type.equals("asx")) {
            return 0;
        } else if (type.equals("flv")) {
            return 0;
        }
        // 对ffmpeg无法解析的文件格式(wmv9，rm，rmvb等),
        // 可以先用别的工具（mencoder）转换为avi(ffmpeg能解析的)格式.
        else if (type.equals("wmv9")) {
            return 1;
        } else if (type.equals("rm")) {
            return 1;
        } else if (type.equals("rmvb")) {
            return 1;
        }
        return 9;
    }
    private static boolean checkfile(String path) {
        File file = new File(path);
        if (!file.isFile()) {
            return false;
        }
        return true;
    }
    // 对ffmpeg无法解析的文件格式(wmv9，rm，rmvb等), 可以先用别的工具（mencoder）转换为avi(ffmpeg能解析的)格式.
    private static String processAVI(int type, String fileName) {
        List<String> commend = new ArrayList<String>();
        commend.add("c:\\ffmpeg\\mencoder");
        commend.add(PATH);
        commend.add("-oac");
        commend.add("lavc");
        commend.add("-lavcopts");
        commend.add("acodec=mp3:abitrate=64");
        commend.add("-ovc");
        commend.add("xvid");
        commend.add("-xvidencopts");
        commend.add("bitrate=600");
        commend.add("-of");
        commend.add("avi");
        commend.add("-o");
        commend.add("c:\\ffmpeg\\output\\"+fileName+".avi");
        try {
            ProcessBuilder builder = new ProcessBuilder();
            builder.command(commend);
            builder.start();
            return "c:\\ffmpeg\\output\\"+fileName+".avi";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    // ffmpeg能解析的格式：（asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv等）
    @SuppressWarnings("unused")
    private static boolean processFLV(String oldfilepath, String fileName) {
        if (!checkfile(PATH)) {
            System.out.println(oldfilepath + " is not file");
            return false;
        }

        // 文件命名
        Calendar c = Calendar.getInstance();
        String savename = String.valueOf(c.getTimeInMillis())+ Math.round(Math.random() * 100000);
        List<String> commend = new ArrayList<String>();
        commend.add("c:\\ffmpeg\\ffmpeg");
        commend.add("-i");
        commend.add(oldfilepath);
        commend.add("-ab");
        commend.add("56");
        commend.add("-ar");
        commend.add("22050");
        commend.add("-qscale");
        commend.add("8");
        commend.add("-r");
        commend.add("15");
        commend.add("-s");
        commend.add("600x500");
        commend.add("c:\\ffmpeg\\output\\"+fileName+".flv");
        // 截取视频的一帧图片作为显示使用
        try {
            Runtime runtime = Runtime.getRuntime();
            Process proce = null;
            String cmd = "";
            String cut = "     c:\\ffmpeg\\ffmpeg.exe   -i   "
                    + oldfilepath
                    + "   -y   -f   image2   -ss   8   -t   0.001   -s   600x500   c:\\ffmpeg\\output\\"
                    + ""+fileName+".jpg";
            String cutCmd = cmd + cut;
            proce = runtime.exec(cutCmd);
            ProcessBuilder builder = new ProcessBuilder(commend);
            builder.command(commend);
            builder.start();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
