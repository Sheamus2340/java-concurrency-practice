package com.jdk8.level02;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Sheamus on 2018/6/22.
 */
public class ArraysTest {

    public static void main(String[] args) {
        String[] str = {"a","b","c"};
        List listStr = Arrays.asList(str);
        System.out.println(listStr.size());

        int[] i = {1,2,3};
        List listI = Arrays.asList(i);
        System.out.println(listI.size());

        Integer[] in = {1,2,3};
        List<Integer> listIn = Arrays.asList(in);
        System.out.println(listIn.size());//3
    }

}
