package com.sheamus.level05;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Sheamus on 2018/6/14.
 */
public class ScheduleExecutorServiceDemo {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(10);
        //注意：前面的任务没有完成，下一个任务的调度不会启动
        scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println("----");
            }
        },0,2, TimeUnit.SECONDS);

    }

}
