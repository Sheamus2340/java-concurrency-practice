package com.sheamus.level02;

/**
 * Created by Sheamus on 2018/6/7.
 */
public class VolatileTest extends Thread {

    private boolean stop;

    @Override
    public void run() {
        int i = 0;
        while(!stop) {
            i++;
        }
        System.out.println("finish loop ,i = " + i);
    }

    public void stopIt() {
        stop = true;
    }

    public boolean getStop() {
        return stop;
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileTest v = new VolatileTest();
        v.start();
        Thread.sleep(1000);
        v.stopIt();
        Thread.sleep(2000);
        System.out.println("finish main");
        System.out.println(v.getStop());
    }

}
