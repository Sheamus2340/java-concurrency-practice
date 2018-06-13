package com.sheamus.level04;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by Sheamus on 2018/6/8.
 */
public class AtomicReferenceDemo {

    private static AtomicReference<String> atomicStr = new AtomicReference<>("abc");

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int num = i;
            new Thread("Thread" + num) {
                @Override
                public void run() {
                    try {
                        Thread.sleep((int)(Math.random() * 100));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if(atomicStr.compareAndSet("abc","def")) {
                        System.out.println("Thread : " + Thread.currentThread().getName() + " change value ： " + atomicStr.get());
                    } else {
                        System.out.println("Thread : " + Thread.currentThread().getName() + " failed ：" +  atomicStr.get());
                    }

                }
            }.start();
        }
    }

}
