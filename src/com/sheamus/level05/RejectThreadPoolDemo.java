package com.sheamus.level05;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.*;

/**
 * Created by Sheamus on 2018/6/14.
 */
public class RejectThreadPoolDemo {

    public static class MyTask implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyTask task = new MyTask();
        ThreadPoolExecutor ess = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.SECONDS, new SynchronousQueue<>(), new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println(r.toString() + " is disCard!");
            }
        });

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            ess.submit(task);
            Thread.sleep(10);
        }

    }

}
