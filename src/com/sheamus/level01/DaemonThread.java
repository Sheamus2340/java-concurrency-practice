package com.sheamus.level01;

/**
 * Created by Sheamus on 2018/6/6.
 */
public class DaemonThread {
    public static class DaemonT extends Thread {
        @Override
        public void run() {
            while(true) {
                System.out.println("I am alive");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DaemonT t = new DaemonT();
        t.setDaemon(true);
        t.start();
//        Thread.sleep(2000);
    }

}
