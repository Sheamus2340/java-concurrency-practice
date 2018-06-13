package com.sheamus.level03;

/**
 * Created by Sheamus on 2018/6/7.
 */
public class APlus {

    private static int a = 0;

    static class A extends Thread {
        @Override
        public void run() {
            a++;
        }
    }

    static class B extends Thread {
        @Override
        public void run() {
            a--;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        A t1 = new A();
        B t2 = new B();
        t1.start();
        t2.start();
        t1.join();
        System.out.println(a);

    }

}
