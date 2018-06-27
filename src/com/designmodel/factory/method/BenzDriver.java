package com.designmodel.factory.method;

/**
 * Created by Sheamus on 2018/6/27.
 */
public class BenzDriver implements Driver {
    @Override
    public Car driverCar() {
        return new BenzCar();
    }
}
