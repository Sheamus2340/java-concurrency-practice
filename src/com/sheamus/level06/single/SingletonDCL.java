package com.sheamus.level06.single;

/**
 * Created by Sheamus on 2018/6/19.
 */
public class SingletonDCL {
    private volatile static SingletonDCL singleton;

    private SingletonDCL(){}

    public static SingletonDCL getInstance(){
        if(singleton == null){                              // 1
            synchronized (SingletonDCL.class){                 // 2
                if(singleton == null){                      // 3
                    singleton = new SingletonDCL();            // 4
                }
            }
        }
        return singleton;
    }
}
