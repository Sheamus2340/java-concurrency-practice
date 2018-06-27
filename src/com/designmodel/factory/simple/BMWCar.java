package com.designmodel.factory.simple;

/**
 * Created by Sheamus on 2018/6/27.
 */
public class BMWCar implements Car {
    @Override
    public void drive() {
        System.out.println("BMW driving");
    }
}
