package com.lock;

import java.util.HashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * description:读写锁
 *
 * @author weishi.zeng
 * @version 1.0
 * @date 2019/10/24 11:46
 */
public class ReadWriteLockDemo {
    private HashMap<String,String > hashMap = new HashMap<String, String>();
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
    private ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

    public String get(String key) {
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"读操作已加锁，开始读操作！");
            Thread.sleep(3000);
            return hashMap.get(key);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } finally {
            System.out.println(Thread.currentThread().getName()+"读操作已解锁！");
            readLock.unlock();
        }
    }

    public void put() {
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"写操作已加锁，开始写操作！");
            Thread.sleep(3000);
            hashMap.put("lock","testLock");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName()+"写操作已完成！");
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        final ReadWriteLockDemo readWriteLockDemo = new ReadWriteLockDemo();
        readWriteLockDemo.put();
        new Thread(new Runnable() {
            public void run() {
                String lock = readWriteLockDemo.get("lock");
            }
        },"thread1").start();
        new Thread(new Runnable() {
            public void run() {
                String lock = readWriteLockDemo.get("lock");
            }
        },"thread2").start();
        new Thread(new Runnable() {
            public void run() {
                String lock = readWriteLockDemo.get("lock");
            }
        },"thread3").start();

    }
}
