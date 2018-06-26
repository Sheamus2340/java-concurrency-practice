package com.designmodel.builder;

/**
 * Created by Sheamus on 2018/6/26.
 */
public class Main {
    public static void main(String[] args) {
        Student student = new Student.Builder().address("北京").id(1).name("张三").passwd("123").sex("男").build();
        System.out.println(student);

        Student2 student2 = new Student2.Builder().address("北京").id(1).name("张三").passwd("123").sex("男").build();
        System.out.println(student2);
    }
}
