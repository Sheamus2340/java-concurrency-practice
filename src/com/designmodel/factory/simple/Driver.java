package com.designmodel.factory.simple;

/**
 * Created by Sheamus on 2018/6/27.
 */
public class Driver {
    public static Car driverCar(String name) throws Exception {
        if(name.equals("BenZ")) {
            return new BenzCar();
        } else if(name.equals("BMW")) {
            return new BMWCar();
        } else {
            throw new Exception();
        }
    }
}
