package com.designmodel.factory.method;

/**
 * Created by Sheamus on 2018/6/27.
 */
public class Magnate {
    public static void main(String[] args) {
        Driver driver = new BenzDriver();
        Car car = driver.driverCar();
        car.drive();
    }
}
