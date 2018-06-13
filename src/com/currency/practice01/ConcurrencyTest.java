package com.currency.practice01;

/**
 * Created by Sheamus on 2018/6/8.
 */
public class ConcurrencyTest {
    private static final long count = 100000000l;

    public static void main(String[] args) throws InterruptedException {
        concurrentcy();
        serial();
    }

    private static void concurrentcy() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread() {
            @Override
            public void run() {
                int a = 0;
                for (long i = 0; i < count; i++) {
                    a += 5;
                }
            }
        };
        thread.start();
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        thread.join();
        long time = System.currentTimeMillis() - start;
        System.out.println("concurrency:" + time + "ms,b=" + b);

    }

    private static void serial() {
        long start = System.currentTimeMillis();
        int a = 0;
        for (long i = 0; i < count; i++) {
            a += 5;
        }
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("Serial:" + time + "ms,b=" + b + ",a=" + a);
    }

}
