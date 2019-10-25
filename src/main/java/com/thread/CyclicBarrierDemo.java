package com.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * description:CyclicBarrier实现
 * CyclicBarrier：让一组线程等待至某个状态之后再全部执行
 *
 * @author weishi.zeng
 * @version 1.0
 * @date 2019/10/23 18:07
 */
public class CyclicBarrierDemo {
    //参数是参与CyclicBarrier的线程数
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
    private void startThread() {
        String name = Thread.currentThread().getName();
        System.out.println(name+"正在准备！");
        try {
            //调用await方法等待全部线程准备完成
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(name+"已准备完毕！"+System.currentTimeMillis());
    }

    public static void main(String[] args) {
        final CyclicBarrierDemo cyclicBarrierDemo = new CyclicBarrierDemo();
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                cyclicBarrierDemo.startThread();
            }
        }, "线程1");
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                cyclicBarrierDemo.startThread();
            }
        }, "线程2");
        Thread thread3 = new Thread(new Runnable() {
            public void run() {
                cyclicBarrierDemo.startThread();
            }
        }, "线程3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}







