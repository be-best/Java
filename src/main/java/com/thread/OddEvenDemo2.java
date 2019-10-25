package com.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * description:使用Condition方式打印奇数偶数
 *
 * @author weishi.zeng
 * @version 1.0
 * @date 2019/10/23 17:06
 */
public class OddEvenDemo2 {
    private int i = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    /**
     * description: 奇数打印
     * @author weishi.zeng
     * @date 2019/10/23 16:53
     * @return void
     */
    public void odd() {
        while(i < 10) {
            lock.lock();
            try {
                if (i % 2 !=0) {
                    System.out.println("奇数打印："+i);
                    ++i;
                    condition.signal();
                } else {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                lock.unlock();
            }
        }
    }

    /**
     * description: 偶数打印
     * @author weishi.zeng
     * @date 2019/10/23 16:56
     * @param
     * @return
     */
    public void even() {
        while (i < 10) {
            lock.lock();
            try {
                if (i % 2 == 0) {
                    System.out.println("偶数打印："+i);
                    ++i;
                    condition.signal();
                } else {
                    try {
                       condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        final OddEvenDemo2 oddEvenDemo = new OddEvenDemo2();
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                oddEvenDemo.odd();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                oddEvenDemo.even();
            }
        });
        thread1.start();
        thread2.start();
    }

}
