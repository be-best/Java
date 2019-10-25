package com.local;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * description:AtomicStampedReference解决ABA问题（加版本号）
 *
 * @author weishi.zeng
 * @version 1.0
 * @date 2019/10/24 11:17
 */
public class ThreadAtomicStamped {
    static AtomicStampedReference<Integer> atomicStampedReference;

    public static void main(String[] args) {
        int j = 0;
        while (j < 100) {
            //设置初始变量值和初始时间戳变量值（类似版本号）
            atomicStampedReference = new AtomicStampedReference(0,0);
            Thread thread1 = new Thread(new Runnable() {
                public void run() {
                    for (int i = 0;i < 1000;i++) {
                        int stamp;
                        Integer reference;
                        do {
                            //获取预期值
                            stamp = atomicStampedReference.getStamp();
                            reference = atomicStampedReference.getReference();
                            //如果预期值不符说明其他线程有修改，重新获取，符合的话更新值
                        } while (!atomicStampedReference.compareAndSet(reference,reference+1,stamp,stamp+1));
                    }
                }
            });
            Thread thread2 = new Thread(new Runnable() {
                public void run() {
                    for (int i = 0;i < 1000;i++) {
                        int stamp;
                        Integer reference;
                        do {
                            //获取预期值
                            stamp = atomicStampedReference.getStamp();
                            reference = atomicStampedReference.getReference();
                            //如果预期值不符说明其他线程有修改，重新获取，符合的话更新值
                        } while (!atomicStampedReference.compareAndSet(reference,reference+1,stamp,stamp+1));
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
            System.out.println("n的最终值是："+atomicStampedReference.getReference()+"---"+atomicStampedReference);
        }
    }
}
