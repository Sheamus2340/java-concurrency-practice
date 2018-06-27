package com.designmodel.factory.simple;

/**
 * Created by Sheamus on 2018/6/27.
 */
public class Magnate {
    public static void main(String[] args){
        try {
            //告诉司机我今天坐奔驰
            Car car = Driver.driverCar("BenZ");
            //下命令：开车
            car.drive();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
