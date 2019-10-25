package com.local;

import com.thread.MyRunnable;

/**
 * description:ThreadLocal实现
 *
 * @author weishi.zeng
 * @version 1.0
 * @date 2019/10/24 9:39
 */
public class ThreadLocalDemo {
    static class Bank {
        private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
            //初始化副本值
            @Override
            protected Integer initialValue() {
                return 0;
            }
        };
        public Integer get() {
            return threadLocal.get();
        }
        public void set(Integer money) {
            threadLocal.set(threadLocal.get() + money);
        }
    }

    static class Transfer implements Runnable {
        private Bank bank;
        public Transfer(Bank bank) {
            this.bank = bank;
        }
        public void run() {
            for (int i = 0;i < 10;i++) {
                bank.set(10);
                System.out.println(Thread.currentThread().getName()+"账户余额："+bank.get());
            }
        }
    }

    public static void main(String[] args) {
        Bank bank = new Bank();
        Transfer transfer = new Transfer(bank);
        Thread thread1 = new Thread(transfer, "客户1");
        Thread thread2 = new Thread(transfer, "客户2");
        thread1.start();
        thread2.start();
    }
}
