package com.thread;

import java.util.Date;

/**
 * description:TODO
 *
 * @author weishi.zeng
 * @version 1.0
 * @date 2019/10/23 14:49
 */
public class MyRunnable implements Runnable {
    public void run() {
        for (int i = 0;i < 10;++i) {
            System.out.println(Thread.currentThread().getName() + "执行时间：" + System.currentTimeMillis() + ";执行次数：" + i);
        }
    }
}
