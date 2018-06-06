package com.sheamus.level01;

/**
 * Created by Sheamus on 2018/6/6.
 */
public class JoinThread {
    public static void main(String[] args) {
        Thread previousThread = Thread.currentThread();
        for (int i = 1; i <= 10; i++) {
            Thread curThread = new JoinThreadM(previousThread,i);
            curThread.start();
            previousThread = curThread;
        }
    }

    static class JoinThreadM extends Thread {
        private Thread thread;
        private int i;

        public JoinThreadM(Thread thread,int i) {
            this.thread = thread;
            this.i = i;
        }

        @Override
        public void run() {
            try {
                thread.join();
                System.out.println(i);
//                System.out.println(thread.getName() + " terminated.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
