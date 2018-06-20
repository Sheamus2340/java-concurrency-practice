package com.sheamus.level06.single;

/**
 * Created by Sheamus on 2018/6/15.
 */
public class StaticSingleton {

    private StaticSingleton(){}

    private static class InstanceHodler {
       static StaticSingleton instance = new StaticSingleton();
    }

    public static StaticSingleton getInstance() {
        return InstanceHodler.instance;
    }

}
