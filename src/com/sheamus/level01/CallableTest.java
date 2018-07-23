package com.sheamus.level01;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by Sheamus on 2018/7/8.
 */
public class CallableTest implements Callable<String> {

    @Override
    public String call() throws Exception {
        String path = "aa";
        return path;
    }

    public static void main(String[] args) throws Exception {
        CallableTest callableTest = new CallableTest();
        FutureTask<String> task = new FutureTask<String>(callableTest);
        new Thread(task).start();
        String s = task.get();
        System.out.println(s);

    }
}
