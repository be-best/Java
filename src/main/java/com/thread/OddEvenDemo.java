package com.thread;

/**
 * description:使用synchronized实现奇数偶数分别打印
 *
 * @author weishi.zeng
 * @version 1.0
 * @date 2019/10/23 16:51
 */
public class OddEvenDemo {
    private int  i = 0;
    private Object obj = new Object();

    /**
     * description: 奇数打印
     * @author weishi.zeng
     * @date 2019/10/23 16:53
     * @return void
     */
    public void odd() {
       while(i < 10) {
           synchronized (obj) {
               if (i % 2 !=0) {
                   System.out.println("奇数打印："+i);
                   ++i;
                   obj.notify();
               } else {
                   try {
                       obj.wait();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
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
            synchronized (obj) {
                if (i % 2 == 0) {
                    System.out.println("偶数打印："+i);
                    ++i;
                    obj.notify();
                } else {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        final OddEvenDemo oddEvenDemo = new OddEvenDemo();
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
