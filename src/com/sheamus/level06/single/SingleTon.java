package com.sheamus.level06.single;

/**
 * 这个方式有一个问题是singleTon对象会在启动项目时就创建了
 *
 * Created by Sheamus on 2018/6/14.
 */
public class SingleTon {
    private static int status = 3;
    private static SingleTon singleTon = new SingleTon();

    private SingleTon() {
        System.out.println("SingleTon is Create");
    }

    public static SingleTon getInstace() {
        return singleTon;
    }

}
