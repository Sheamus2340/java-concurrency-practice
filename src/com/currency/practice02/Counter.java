package com.currency.practice02;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Sheamus on 2018/6/11.
 */
public class Counter {
    private AtomicInteger atomicI = new AtomicInteger(0);
    private int i = 0;

    public static void main(String[] args) throws InterruptedException {
        final Counter cas = new Counter();
        List<Thread> ts = new ArrayList<>(600);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(){
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        cas.unSafeCount();
                        cas.safeCount();
                    }
                }
            };
            ts.add(t);
        }

        for (Thread t : ts) {
            t.start();
        }

        for(Thread t : ts) {
            t.join();
        }

        System.out.println(cas.i);
        System.out.println(cas.atomicI.get());
        System.out.println(System.currentTimeMillis() - start);

    }

    /** * 使用CAS实现线程安全计数器 */
    private void safeCount() {
        for (;;) {
            int i = atomicI.get();
            boolean b = atomicI.compareAndSet(i, ++i);
            if(b) {
               break;
            }
        }
    }

    /** * 非线程安全计数器 */
    private void unSafeCount() {
        i++;
    }


}
