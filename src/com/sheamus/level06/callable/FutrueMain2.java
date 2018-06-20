package com.sheamus.level06.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Sheamus on 2018/6/15.
 */
public class FutrueMain2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        //执行FutureTask，相当于上例中的client.request("a")发送请求
        //在这里开启线程进行RealData的call()执行
        Future<String> future = executor.submit(new RealData("a"));
        Thread.sleep(2000);
        System.out.println("数据：" + future.get());
    }
}
