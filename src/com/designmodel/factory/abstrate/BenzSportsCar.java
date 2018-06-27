package com.designmodel.factory.abstrate;

/**
 * Created by Sheamus on 2018/6/27.
 */
public class BenzSportsCar extends BenZCar implements SportsCar {

    @Override
    public void sports() {
        System.out.println("奔驰跑车");
    }
}
