package com.designmodel.factory.abstrate;

/**
 * Created by Sheamus on 2018/6/27.
 */
public class BmwSportsCar extends BmwCar implements SportsCar {
    @Override
    public void sports() {
        System.out.println("宝马跑车");
    }
}
