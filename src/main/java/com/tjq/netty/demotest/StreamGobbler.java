/**
 * =============================================================
 * Copyright 2019 Lianjia Group All Rights Reserved
 * ClassName: StreamGobbler
 * version: 1.0.0
 * date: 2019/5/30
 * author: Tyson
 * =============================================================
 */
package com.tjq.netty.demotest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author Tyson
 * @version V1.0
 * @Description: TODO
 * @date 2019/5/30上午10:29
 */
public class StreamGobbler extends Thread {

    private InputStream is;
    String type;

    public StreamGobbler(InputStream is, String type) {
        this.is = is;
        this.type = type;
    }

    @Override
    public void run() {
        try {
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                if (type.equals("Error")) {
                    sb.append(line + "\n");
                } else {
                    sb.append(line + "\n");
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
