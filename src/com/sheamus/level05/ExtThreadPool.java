package com.sheamus.level05;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Sheamus on 2018/6/14.
 */
public class ExtThreadPool {

    public static class MyTask extends Thread {

        private String name;

        public MyTask(String name) {
            super(name);
            this.name = name;
        }

        @Override
        public void run() {

        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = new ThreadPoolExecutor(5,5,0L, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>()){
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                System.out.println("准备执行: " + ((MyTask)r).name);
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                System.out.println("执行完成: " + ((MyTask)r).name);
            }

            @Override
            protected void terminated() {
                System.out.println("线程池退出");
            }
        };

        for (int i = 0; i < 5; i++) {
            MyTask task = new MyTask("TASK-GEYM" + i);
            service.execute(task);
            Thread.sleep(10);
        }
        service.shutdown();
    }
}
