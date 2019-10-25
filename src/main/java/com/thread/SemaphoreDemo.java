package com.thread;

import java.util.concurrent.Semaphore;

/**
 * description:Semaphore实现
 * SemaphoreDemo：用于控制对某组资源的访问权限
 * 如果许可数达到最大活动数，那么调用acquire()之后，便进入等待队列，
 * 等待已获得许可的线程释放许可，从而使得多线程能够合理的运行。
 *
 * @author weishi.zeng
 * @version 1.0
 * @date 2019/10/23 18:15
 */
public class SemaphoreDemo {
    static class Work implements Runnable {
        private int workNum;//工人工号
        private Semaphore semaphore;//机器数

        public Work(int workNum, Semaphore semaphore) {
            this.workNum = workNum;
            this.semaphore = semaphore;
        }

        public void run() {
            try {
                //工人获取机器
                semaphore.acquire();
                //打印工人获取到机器，开始工作
                String name = Thread.currentThread().getName();
                System.out.println(name+"获取到机器，开始工作！");
                //线程睡眠1000毫秒，模拟工作
                Thread.sleep(1000);
                //使用完毕，释放机器
                semaphore.release();
                System.out.println(name+"使用完毕，释放机器");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        //8个工人
        int workers = 8;
        //3台机器
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0;i < workers;++i) {
            new Thread(new Work(i,semaphore)).start();
        }
    }
}
