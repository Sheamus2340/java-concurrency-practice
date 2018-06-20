package com.sheamus.level05;

/**
 * Created by Sheamus on 2018/6/14.
 */
public class StringTest {
    public static void main(String[] args) {
        System.out.println("Java".equals(new String("Java")));
        System.out.println("Java".equals(new StringBuilder("Java")));
        System.out.println("Java".equals(new StringBuilder("Java").toString()));
    }
}
