package com.sheamus.level05;

/**
 * Created by Sheamus on 2018/6/14.
 */
public class ThreadPoolTest {

    static class Task implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println("----------------------");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ThreadPool pool = ThreadPool.getInstance();
        Task task = new Task();
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);
        Thread t4 = new Thread(task);
        Thread t5 = new Thread(task);
        Thread t6 = new Thread(task);
        Thread t7 = new Thread(task);
        Thread t8 = new Thread(task);
        Thread t9 = new Thread(task);
        pool.start(t1);
        pool.start(t2);
        pool.start(t3);
        pool.start(t4);
        pool.start(t5);
        pool.start(t6);
        pool.start(t7);
        pool.start(t8);
        pool.start(t9);






    }
}
