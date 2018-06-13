package com.sheamus.level02;

/**
 * Created by Sheamus on 2018/6/7.
 */
public class Increase extends Thread {
    private static volatile int a;
//    private static int b;

    @Override
    public void run() {
        for(int i = 0; i < 100000; i++) {
            synchronized (Increase.class) {
                a++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 100; i++) {
            Increase t = new Increase();
            t.start();
//            t.join();
        }

        Thread.sleep(10000);

        System.out.println(a);
//        System.out.println(b);

    }
}
