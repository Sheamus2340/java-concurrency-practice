package com.designmodel.factory.method;

/**
 * Created by Sheamus on 2018/6/27.
 */
public class BmwCar implements Car {
    @Override
    public void drive() {
        System.out.println("宝马");
    }
}
