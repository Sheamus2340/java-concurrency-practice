package com.sheamus.level02;

/**
 * 指令重排
 * Created by Sheamus on 2018/6/7.
 */
public class OrderlyTest {

    private static int a = 1;
    private static int b = 2;
    private static  int r1 = 3;
    private static  int r2 = 4;

    static class ThreadOne extends Thread {
        @Override
        public void run() {
            r2 = a;
            b = 1;
        }
    }

    static class ThreadTwo extends Thread {
        @Override
        public void run() {
            r1 = b;
            a = 2;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadOne t1 = new ThreadOne();
        ThreadTwo t2 = new ThreadTwo();
        t1.start();

        t2.start();



        t1.join();
        t2.join();

        System.out.println("a : " + a);
        System.out.println("b : " + b);
        System.out.println("r1 : " + r1);
        System.out.println("r2 : " + r2);
    }

}


