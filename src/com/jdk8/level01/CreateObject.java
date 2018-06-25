package com.jdk8.level01;

import java.io.*;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Sheamus on 2018/6/21.
 */
public class CreateObject {
    public static void main(String[] args) {
        //方式 1
        Apple apple1 = new Apple();
        System.out.println(apple1);
        //方式 2
        try {
            Class<?> clazz = Class.forName("com.jdk8.level01.Apple");
            Apple apple2 = (Apple)clazz.newInstance();
            System.out.println(apple2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        //方式 3
        try {
            Apple apple3 = (Apple)Apple.class.getConstructors()[0].newInstance();
            System.out.println(apple3);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //方式 4
        Apple apple4 = (Apple)apple1.clone();
        System.out.println(apple4);

        //方式 5
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("E:\\01-workspace\\01-workspace-IDEA\\01-workspace-javacore\\java-concurrency\\src\\com\\jdk8\\level01\\io" + File.separator + "a.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(new Apple("富士苹果"));
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        InputStream in = null;
        try {
            in = new FileInputStream("E:\\01-workspace\\01-workspace-IDEA\\01-workspace-javacore\\java-concurrency\\src\\com\\jdk8\\level01\\io"+ File.separator+"a.txt");
            ObjectInputStream os = new ObjectInputStream(in);
            Apple p = (Apple) os.readObject();
            System.out.println(p);
            os.close();
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}

class Apple implements Cloneable,Serializable {
    private static final long serialVersionUID = 8656128222714547171L;

    String name;

    public Apple() {}

    public Apple(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object clone() {
        try {
           return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
