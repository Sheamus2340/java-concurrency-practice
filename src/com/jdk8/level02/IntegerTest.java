package com.jdk8.level02;

/**
 * Created by Sheamus on 2018/6/21.
 */
public class IntegerTest {
    public static void main(String[] args) {
        Integer i = 10;
        Integer j = 10;
        System.out.println(i == j);

        Integer a = 128;
        Integer b = 128;
        System.out.println(a == b);

        int k = 10;
        System.out.println(k == i);

        Integer sd = new Integer(128);
        System.out.println(sd.equals(128));

    }
}
