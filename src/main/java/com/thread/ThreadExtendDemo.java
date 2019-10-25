package com.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * description:TODO
 *
 * @author weishi.zeng
 * @version 1.0
 * @date 2019/10/23 14:55
 */
public class ThreadExtendDemo {
    public static void main(String[] args) {
        //线程池创建线程
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(new MyRunnable());
        //打印主线程
        for (int i= 0;i < 10;++i) {
            System.out.println(Thread.currentThread().getName()+"执行时间："+System.currentTimeMillis()+";执行次数："+i);
        }
    }
}
