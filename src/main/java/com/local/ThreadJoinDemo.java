package com.local;

/**
 * description:join()
 *
 * @author weishi.zeng
 * @version 1.0
 * @date 2019/10/24 10:41
 */
public class ThreadJoinDemo {
    private static int  n;
    public static void main(String[] args) {
         int j = 0;
         while (j < 100) {
             n = 0;
             Thread thread1 = new Thread(new Runnable() {
                 public void run() {
                     for (int i = 0; i < 1000; i++) {
                         n++;
                     }
                 }
             });
             Thread thread2 = new Thread(new Runnable() {
                 public void run() {
                     for (int i = 0; i < 1000; i++) {
                         n++;
                     }
                 }
             });
             j++;
             thread1.start();
             thread2.start();
             try {
                 //join使两个线程加入主线程，join会使等待两个线程执行完毕之后再打印 System.out.println("n的最终值："+n);
                 thread1.join();
                 thread2.join();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             System.out.println("n的最终值："+n);
         }
    }
}
