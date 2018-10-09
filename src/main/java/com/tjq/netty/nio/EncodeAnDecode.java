/**
 * =============================================================
 * Copyright 2018 Lianjia Group All Rights Reserved
 * CompanyName: 上海链家有限公司
 * SystemName: 贝壳
 * ClassName: EncodeAnDecode
 * version: 1.0.0
 * date: 2018/9/20
 * author: Tyson
 * =============================================================
 */
package com.tjq.netty.nio;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * @author Tyson
 * @version V1.0
 * @Description: 字符集编解码
 * @date 2018/9/20下午4:24
 */
public class EncodeAnDecode {
    public static void main(String[] args) throws Exception {
        String input = "EncodeAnDecode_in.txt";
        String output = "EncodeAnDecode_out.txt";
        RandomAccessFile inputRandomAccessFile = new RandomAccessFile(input, "r");
        RandomAccessFile outputRandomAccessFile = new RandomAccessFile(output, "rw");

        long inputLength = new File(input).length();
        FileChannel inputChannel = inputRandomAccessFile.getChannel();
        FileChannel outputChannel = outputRandomAccessFile.getChannel();

        MappedByteBuffer inputData = inputChannel.map(FileChannel.MapMode.READ_ONLY, 0, inputLength);

        System.out.println("====================");
        Charset.availableCharsets().forEach((k, v) -> {
            System.out.println(k + "  ," + v);
        });
        System.out.println("====================");

//        Charset charset = Charset.forName("utf-8");
        Charset charset = Charset.forName("iso-8859-1");
        CharsetDecoder charsetDecoder = charset.newDecoder();
        CharsetEncoder charsetEncoder = charset.newEncoder();

        CharBuffer charBuffer = charsetDecoder.decode(inputData); //将字节解码成char
        ByteBuffer outputdata = charsetEncoder.encode(charBuffer); //将char编码成字节
        outputChannel.write(outputdata);
        inputRandomAccessFile.close();
        outputRandomAccessFile.close();


    }
}
