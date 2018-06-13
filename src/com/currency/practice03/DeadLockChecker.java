package com.currency.practice03;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * Created by Sheamus on 2018/6/13.
 */
public class DeadLockChecker {
    private final static ThreadMXBean mBean = ManagementFactory.getThreadMXBean();
    final static Runnable deadLockChecker = new Runnable() {
        @Override
        public void run() {
            while(true) {
                long[] deadlockedThreads = mBean.findDeadlockedThreads();
                if(deadlockedThreads != null) {
                    ThreadInfo[] threadInfo = mBean.getThreadInfo(deadlockedThreads);
                    for(Thread t : Thread.getAllStackTraces().keySet()) {
                        for (int i = 0; i < threadInfo.length; i++) {
                            if(t.getId() == threadInfo[i].getThreadId()) {
                                t.interrupt();
                            }
                        }
                    }
                }
                try{
                   Thread.sleep(5000);
                }catch (InterruptedException e){

                }

            }
        }
    };

    public static void check() {
        Thread t = new Thread(deadLockChecker);
        t.setDaemon(true);
        t.start();
    }

}
