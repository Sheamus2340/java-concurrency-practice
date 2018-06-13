package com.sheamus.level03;

/**
 * Created by Sheamus on 2018/6/7.
 */
public class MonitorDemo extends Thread {

    private volatile int a = 0;

    @Override
    public void run() {
        synchronized (this) {
            a++;
        }

    }

    public synchronized void reader() {
        for (int i = 0; i < 1000; i++) {
            int j = a;
            System.out.println(j);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MonitorDemo demo = new MonitorDemo();
        demo.start();
        demo.reader();
    }

}
