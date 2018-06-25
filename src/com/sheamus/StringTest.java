package com.sheamus;

import java.lang.reflect.Field;

/**
 * Created by Sheamus on 2018/6/19.
 */
public class StringTest {
    public static void main(String[] args) throws Exception {
        String a = "Sheamus";
        String b = "Sheamus";
        String c = new String("Sheamus");
        System.out.println("--------------修改前值-------------------");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        //修改String的值
        Field a_ = String.class.getDeclaredField("value");
        a_.setAccessible(true);
        char[] value=(char[])a_.get(a);
        value[4]='_';   //修改a所指向的值

        System.out.println("--------------修改后值-------------------");
        /*System.out.println("a = " + a);
        System.out.println("b = " + b);*/
        System.out.println("Sheamus");

       /* System.out.println("c = " + c);

        System.out.println(a == b);
        System.out.println(c == b);
        System.out.println(a == c);
        System.out.println(a == "Sheamus");
        System.out.println(b == "Sheamus");
        System.out.println(c == "Sheamus");*/

       /* System.out.println(a.equals("Sheamus"));
        System.out.println(b.equals("Sheamus"));
        System.out.println(c.equals("Sheamus"));

        System.out.println(a.toString().equals("Sheamus"));
        System.out.println(b.toString().equals("Sheamus"));
        System.out.println(c.toString().equals("Sheamus"));

        System.out.println(a.toString().equals("Sheamus".toString()));
        System.out.println(b.toString().equals("Sheamus".toString()));
        System.out.println(c.toString().equals("Sheamus".toString()));*/

       /* System.out.println("Shea" + "mus");

        System.out.println(new StringBuilder("Shea").append("mus"));*/
    }
}
