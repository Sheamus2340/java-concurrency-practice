package com.currency.practice03;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Sheamus on 2018/6/13.
 */
public class ReentrantLockDemo implements Runnable {
    private static int j = 0;
    private static ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            lock.lock();
            try{
                j++;
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockDemo d = new ReentrantLockDemo();
        ReentrantLockDemo d2 = new ReentrantLockDemo();
        Thread t1 = new Thread(d);
        Thread t2 = new Thread(d2);
        t1.start();t2.start();
        t1.join();t2.join();
        System.out.println("out: " + j);
    }
}
