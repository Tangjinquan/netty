/**
 * =============================================================
 * Copyright 2019 Lianjia Group All Rights Reserved
 * ClassName: AbnormalSemaphoreSample
 * version: 1.0.0
 * date: 2019/5/20
 * author: Tyson
 * =============================================================
 */
package com.tjq.netty.demotest;

/**
 * @Description: TODO
 * @author Tyson
 * @date 2019/5/20下午6:33
 * @version V1.0
 */

import java.util.concurrent.Semaphore;


public class AbnormalSemaphoreSample {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(0);
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new MyWorker(semaphore));
            t.start();
        }
        System.out.println("Action...GO!");
        semaphore.release(5);
        System.out.println("Wait for permits off");
        while (semaphore.availablePermits() != 0) {
            Thread.sleep(100L);
        }
        System.out.println("Action...GO again!");
        semaphore.release(5);
    }
}


class MyWorker implements Runnable {
    private Semaphore semaphore;

    public MyWorker(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println("Executed!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
