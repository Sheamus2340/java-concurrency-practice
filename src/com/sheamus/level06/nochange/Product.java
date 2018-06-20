package com.sheamus.level06.nochange;

/**
 * Created by Sheamus on 2018/6/15.
 */
public final class Product {
    //final 确保不会被第二次赋值
    private final String no;
    private final String name;
    private final double price;

    private Product(String no,String name,double price) {
        this.name = name;
        this.no = no;
        this.price = price;
    }

    public String getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
