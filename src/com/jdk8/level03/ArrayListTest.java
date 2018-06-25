package com.jdk8.level03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Sheamus on 2018/6/22.
 */
public class ArrayListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");


        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            String str = it.next();
            System.out.print(str+" ");
            //list.remove(str);//这个remove会修改modCount;集合遍历时进行删除或者新增操作，都会抛出 ConcurrentModificationException 异常
            it.remove();//这个remove不会修改modCount参数
        }

        System.out.println("--------------------");

        for(String str : list) {
            System.out.println(str);
        }

    }
}
