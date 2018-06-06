package com.sheamus.level01;

/**
 * Created by Sheamus on 2018/6/6.
 */
public class InterruptDemo {
    public static void main(String[] args) {
        final Thread sleepThread = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                super.run();
            }
        };
        //busyThread一直执行死循环
        final Thread busyThread = new Thread() {
            @Override
            public void run() {
                while(true);
            }
        };

        sleepThread.start();
        busyThread.start();
        sleepThread.interrupt();
        busyThread.interrupt();
        while(sleepThread.isInterrupted());
        System.out.println("sleepThread isInterrupted: " + sleepThread.isInterrupted());
        System.out.println("busyThread isInterrupted: " + busyThread.isInterrupted());
    }
}
