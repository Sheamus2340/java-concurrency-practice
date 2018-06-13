package com.sheamus.level04;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 只充值一次
 * Created by Sheamus on 2018/6/8.
 */
public class AtomicStampReferenceDemo {
    static AtomicStampedReference<Integer> money = new AtomicStampedReference<>(19,0);

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            int timstamp = money.getStamp();
            new Thread() {
                @Override
                public void run() {
                    while(true) {
                        while(true) {
                            Integer m = money.getReference();
                            if(m < 20) {
                                if(money.compareAndSet(m,m + 20,timstamp,timstamp + 1)) {
                                    //充值
                                    System.out.println("余额小于20元，充值成功，余额：" + money.getReference() + "元");
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                }
            }.start();
        }

        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    while(true) {
                        int stamp = money.getStamp();
                        Integer m = money.getReference();
                        if(m > 10) {
                            System.out.println("大于10元");
                            if(money.compareAndSet(m,m - 10,stamp,stamp + 1)) {
                                System.out.println("消费 10 元，余额：" + money.getReference());
                            }
                        } else {
                            System.out.println("余额不足");
                            break;
                        }
                    }

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }



}
