package com.designmodel.factory.abstrate;

/**
 * Created by Sheamus on 2018/6/27.
 */
public class SportsDriver implements Driver {
    @Override
    public BenZCar driverBenZCar() {
        return null;
    }

    @Override
    public BmwCar driverBmwCar() {
        return null;
    }

    @Override
    public SportsCar driverSportsCar() {
        return new BenzSportsCar();
    }
}
