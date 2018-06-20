package com.sheamus.level06.single;

/**
 * 懒汉模式的单例
 * Created by Sheamus on 2018/6/14.
 */
public class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton(){
        System.out.println("LazySingleton is create");
    }

    public static synchronized LazySingleton getInstance() {
        if(instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

}
