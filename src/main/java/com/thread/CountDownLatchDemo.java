package com.thread;

import java.util.concurrent.CountDownLatch;

/**
 * description:CountDownLatch运用
 * CountDownLatch：能够使一个线程等待其他线程完成各自的工作之后再执行
 *                 通过计数器实现，计数器初始值为线程的数量。
 *
 * @author weishi.zeng
 * @version 1.0
 * @date 2019/10/23 17:32
 */
public class CountDownLatchDemo {
    private CountDownLatch countDownLatch = new CountDownLatch(3);

    public void racer() {
        try {
            String name = Thread.currentThread().getName();
            System.out.println(name + "开始准备！");
            Thread.sleep(1000);
            System.out.println(name+"准备完成！");
            countDownLatch.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void coach() {
        try {
            String name = Thread.currentThread().getName();
            System.out.println(name + "等待选手准备！");
            countDownLatch.await();
            System.out.println(name + "选手准备完成，开始训练！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        final CountDownLatchDemo countDownLatchDemo = new CountDownLatchDemo();
        Thread coachThread = new Thread(new Runnable() {
            public void run() {
                countDownLatchDemo.coach();
            }
        }, "教练");
        Thread racerThread1 = new Thread(new Runnable() {
            public void run() {
                countDownLatchDemo.racer();
            }
        }, "球员1");
        Thread racerThread2 = new Thread(new Runnable() {
            public void run() {
                countDownLatchDemo.racer();
            }
        }, "球员2");
        Thread racerThread3 = new Thread(new Runnable() {
            public void run() {
                countDownLatchDemo.racer();
            }
        }, "球员3");
        coachThread.start();
        racerThread1.start();
        racerThread2.start();
        racerThread3.start();
    }
}
