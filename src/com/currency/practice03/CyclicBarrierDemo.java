package com.currency.practice03;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Sheamus on 2018/6/13.
 */
public class CyclicBarrierDemo {

    public static class Solider implements Runnable {

        private String solider;
        private final CyclicBarrier cyclic;

        public Solider(CyclicBarrier cyclic, String soliderName) {
            this.solider = soliderName;
            this.cyclic = cyclic;
        }

        @Override
        public void run() {

            try {
                //等待所有士兵到齐
                cyclic.await();
                dowork();
                //等待所有士兵完成工作
                cyclic.await();
            } catch (InterruptedException e) {//被中断的士兵抛出的异常
                e.printStackTrace();
            } catch (BrokenBarrierException e) {//未完成任务的士兵抛出的异常，表示这个任务永远完成不了
                e.printStackTrace();
            }
        }

        private void dowork() {
            try {
                Thread.sleep(Math.abs(new Random().nextInt()%10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("任务完成");
        }
    }

    public static class BarrierRun implements Runnable {

        boolean flag;
        int N;

        public BarrierRun(boolean flag,int N) {
            this.flag = flag;
            this.N = N;
        }


        @Override
        public void run() {
            if(flag) {
                System.out.println("司令：[士兵" + N + "个，任务完成!]");
            } else {
                System.out.println("司令：[士兵" + N + "个，集合完成!]");
                flag = true;
            }
        }
    }

    public static void main(String[] args) {
        final int N = 10;
        Thread[] allSolider = new Thread[N];
        boolean flag = false;
        //调用了多少次await();就会执行相对应的new CyclicBarrier(N,new BarrierRun(flag,N));
        CyclicBarrier cyclicBarrier = new CyclicBarrier(N,new BarrierRun(flag,N));

        System.out.println("队伍集合完毕");

        for (int i = 0; i < N; i++) {
            System.out.println("士兵" + i + "报道！");
            allSolider[i] = new Thread(new Solider(cyclicBarrier,"士兵" + i));
            allSolider[i].start();
            /*if(i == 5) {
                allSolider[0].interrupt();
            }*/
        }

    }
}
