package com.designmodel.factory.method;

/**
 * Created by Sheamus on 2018/6/27.
 */
public class BmwDriver implements Driver {
    @Override
    public Car driverCar() {
        return new BmwCar();
    }
}
