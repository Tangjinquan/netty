/**
 * =============================================================
 * Copyright 2018 Lianjia Group All Rights Reserved
 * CompanyName: 上海链家有限公司
 * SystemName: 贝壳
 * ClassName: PersonProtocol
 * version: 1.0.0
 * date: 2018/11/2
 * author: Tyson
 * =============================================================
 */
package com.tjq.netty.handle2;

/**
 *
 * @Description: TODO
 * @author Tyson
 * @date 2018/11/2上午11:29
 * @version V1.0
 */
public class PersonProtocol {

    private int length;

    private byte[] content;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
