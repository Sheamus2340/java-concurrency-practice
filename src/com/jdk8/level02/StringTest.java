package com.jdk8.level02;

/**
 * Created by Sheamus on 2018/6/21.
 */
public class StringTest {
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "helloworld";
        String str3 = str1 + "world";             //编译器不能确定为常量(会在堆区创建一个String对象)
        String str4 = "hello" + "world";          //编译器确定为常量，直接到常量池中引用

        System.out.println(str2 == str3);
        System.out.println(str2 == str4);
        System.out.println(str3 == str4);

        System.out.println(null == null);

    }
}
