package com.sheamus.level01;

/**
 * Created by Sheamus on 2018/6/6.
 */
public class SimpleWN {
    final static Object object = new Object();
    public static class T1 extends Thread{
        @Override
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + ": T1 start");

                try {
                    System.out.println(System.currentTimeMillis() + ": T1 wait for object");
                    object.wait();//当前线程会释放object的锁
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + ": T1 end");
            }
        }
    }

    public static class T2 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + ": T2 start notify one Thread");

                object.notify();

                System.out.println(System.currentTimeMillis() + ": T2 end");

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();
        t1.start();
        t2.start();
    }

}
