package com.sheamus.level01;

/**
 * Created by Sheamus on 2018/6/6.
 */
public class AccountingSync implements Runnable {
    public static AccountingSync instance = new AccountingSync();
    static int i = 0;

    @Override
    public void run() {
        for (int j = 0; j < 1000000; j++) {
            synchronized (instance) {
                i++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance,"Thread1");
        Thread t2 = new Thread(instance,"Thread2");
        t1.start();t2.start();
        t1.join();t2.join();
        System.out.println("--" + i);
    }
}
