package com.sheamus.level02;

/**
 * A线程执行writer()，线程B执行read()，线程B在执行时能否读到 a = 1 呢？
 * 答案是不一定（注：X86CPU不支持写写重排序，如果是在x86上面操作，
 * 这个一定会是a=1,LZ搞了好久都没有测试出来，最后查资料才发现）。
 * Created by Sheamus on 2018/6/19.
 */
public class RecordExample {
    int a = 0;
    boolean flag = false;

    /**
     * A线程执行
     */
    public void writer(){
        a = 1;                  // 1
        flag = true;            // 2
    }

    /**
     * B线程执行
     */
    public void read(){
        if(flag){                  // 3
            int i = a + a;          // 4
        }
    }

    public static void main(String[] args) throws InterruptedException {
        RecordExample example = new RecordExample();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                example.writer();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                example.read();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(example.a);

    }

}
