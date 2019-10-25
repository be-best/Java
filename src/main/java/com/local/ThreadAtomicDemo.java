package com.local;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * description:AtomicInteger,保证++操作的原子性
 *
 * @author weishi.zeng
 * @version 1.0
 * @date 2019/10/24 10:48
 */
public class ThreadAtomicDemo {
    static AtomicInteger atomicInteger;

    public static void main(String[] args) {
        int j = 0;
        while (j < 100) {
            //创建原子整数，初始值是0
            atomicInteger = new AtomicInteger(0);
            Thread thread1 = new Thread(new Runnable() {
                public void run() {
                    for (int i = 0;i < 1000;i++) {
                        //对应n++
                        atomicInteger.getAndIncrement();
                    }
                }
            });
            Thread thread2 = new Thread(new Runnable() {
                public void run() {
                    for (int i = 0;i < 1000;i++) {
                        //对应n++
                        atomicInteger.getAndIncrement();
                    }
                }
            });
            j++;
            thread1.start();
            thread2.start();
            try {
                thread1.join();
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("n的最终值是：" + atomicInteger.get()+"---"+atomicInteger);

        }
    }
}
