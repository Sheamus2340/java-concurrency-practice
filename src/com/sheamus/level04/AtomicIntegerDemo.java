package com.sheamus.level04;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Sheamus on 2018/6/8.
 */
public class AtomicIntegerDemo {

    private static AtomicInteger at = new AtomicInteger();

    static class AddThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                at.incrementAndGet();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] tk = new Thread[100];
        for (int i = 0; i < 100; i++) {
            tk[i] = new AddThread();
        }

        for (int i = 0; i < 100; i++) {
            tk[i].start();
        }

        for (int i = 0; i < 100; i++) {
            tk[i].join();
        }

        System.out.println(at.get());

    }
}
