package com.sheamus.level06.single;

/**
 * Created by Sheamus on 2018/6/14.
 */
public class SingleTonTest {
    public static void main(String[] args)  {
        Thread[] ts = new Thread[10000];
        for (int i = 0; i < 10000; i++) {
            ts[i] = new Thread(new Runnable() {
                @Override
                public void run() {
//                    SingleTon instance = SingleTon.getInstace();
                    LazySingleton instance = LazySingleton.getInstance();
                    System.out.println(instance);
                }
            });

            ts[i].start();
        }
    }
}
