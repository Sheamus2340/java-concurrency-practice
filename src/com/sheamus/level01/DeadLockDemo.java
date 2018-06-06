package com.sheamus.level01;

/**
 * Created by Sheamus on 2018/6/6.
 */
public class DeadLockDemo {
    private static String resource_a = "a";
    private static String resource_b = "b";

    public static void deadLock() {
        Thread threada = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(resource_a) {
                    System.out.println("get resource a");

                    try {
                        Thread.sleep(3000);
                        synchronized(resource_b) {
                            System.out.println("get resource b");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

        Thread threadb = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(resource_b) {
                    System.out.println("get resource b");

                    try {
                        Thread.sleep(3000);

                        synchronized(resource_a) {
                            System.out.println("get resource a");
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

        threada.start();
        threadb.start();
    }

    public static void main(String[] args) {
        deadLock();
    }
}
