package com.jdk8.level01.shallowcopy;

/**
 * Created by Sheamus on 2018/6/21.
 */
public class Address {
    private String provices;
    private String city;

    public void setAddress(String provices,String city){
        this.provices = provices;
        this.city = city;
    }

    public Address() {
    }

    @Override
    public String toString() {
        return "Address [provices=" + provices + ", city=" + city + "]";
    }
}
