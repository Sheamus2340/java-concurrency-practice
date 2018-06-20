package com.sheamus.level05;

import java.util.List;
import java.util.Vector;

/**
 * 线程池
 * Created by Sheamus on 2018/6/14.
 */
public class ThreadPool {
    private static ThreadPool instance = null;
    //保存空闲的线程队列
    private List<Worker> idleThreads;
    //已有的线程总数
    private int threadCounter;
    private boolean isShutDown = false;

    private ThreadPool() {
        idleThreads = new Vector<>(5);//默认只能装5个线程
        threadCounter = 0;
    }

    public int getCreatedThreadsCount() {
        return threadCounter;
    }

    //获取线程池实例，懒汉模式单例模式
    public synchronized static ThreadPool getInstance() {
        if(instance == null) {
            instance = new ThreadPool();
        }
        return instance;
    }

    //将线程放入线程池中
    protected synchronized void repool(Worker repoolingThread) {
        if(!isShutDown) {
            idleThreads.add(repoolingThread);
        } else {
            repoolingThread.shutDown();//关闭线程
        }
    }

    //停止池中所有线程
    public synchronized void shutdown() {
        isShutDown = true;
        for (int threadIndex = 0; threadIndex < idleThreads.size(); threadIndex++) {
            Worker idleThread = idleThreads.get(threadIndex);
            idleThread.shutDown();
        }
    }

    //执行任务
    public synchronized void start(Runnable target) {
        Worker thread = null;
        if(idleThreads.size() > 0) {
            int lastIndex = idleThreads.size() - 1;
            thread = idleThreads.get(lastIndex);
            idleThreads.remove(lastIndex);
            //立即执行这个任务
            thread.setTarget(target);
        } else {//没有空闲线程，则创建新线程
            threadCounter++;
            //创建新线程
            thread = new Worker(target,"PThread a" + threadCounter,this);
            //启动这个线程
            thread.start();
        }
    }

}
