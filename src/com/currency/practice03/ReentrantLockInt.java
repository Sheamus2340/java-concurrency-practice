package com.currency.practice03;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 可中断的
 * Created by Sheamus on 2018/6/13.
 */
public class ReentrantLockInt implements Runnable{

    private static ReentrantLock lock1 = new ReentrantLock();
    private static ReentrantLock lock2 = new ReentrantLock();

    private int lock;

    public ReentrantLockInt(int lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            if(lock == 1) {
                lock1.lockInterruptibly();
                Thread.sleep(400);
                lock2.lockInterruptibly();
            } else if(lock == 2) {
                lock2.lockInterruptibly();
                Thread.sleep(400);
                lock1.lockInterruptibly();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(lock1.isHeldByCurrentThread()) {
                lock1.unlock();
            }
            if(lock2.isHeldByCurrentThread()) {
                lock2.unlock();
            }
            System.out.println("线程退出了。。。");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockInt r1 = new ReentrantLockInt(1);
        ReentrantLockInt r2 = new ReentrantLockInt(2);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();t2.start();
//        t1.join();t2.join();
        DeadLockChecker.check();
    }
}
