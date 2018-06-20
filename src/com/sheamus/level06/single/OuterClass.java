package com.sheamus.level06.single;

import java.util.Random;

/**
 * 静态内部类的加载过程：
        静态内部类的加载不需要依附外部类，在使用时才加载。不过在加载静态内部类的过程中也会加载外部类。以上花了很多功夫来说明了
 * Created by Sheamus on 2018/6/14.
 */
public class OuterClass {
    public static long OUTER_DATE = System.currentTimeMillis();

    static {
        System.out.println("1. 外部类静态块加载时间：" + System.currentTimeMillis());
    }

    public OuterClass() {
        timeElapsed();
        System.out.println("2. 外部类构造函数时间：" + System.currentTimeMillis());
    }

    static class InnerStaticClass {
        public static long INNER_STATIC_DATE = System.currentTimeMillis();

        public static void main(String[] args) {

        }

    }

    class InnerClass {
        public long INNER_DATE = 0;
        public InnerClass() {
            timeElapsed();
            INNER_DATE = System.currentTimeMillis();
        }
    }

    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        System.out.println("3. 外部类静态变量加载时间：" + outer.OUTER_DATE);
        System.out.println("4. 非静态内部类加载时间" + outer.new InnerClass().INNER_DATE);
        System.out.println("5. 静态内部类加载时间：" + InnerStaticClass.INNER_STATIC_DATE);
    }
    //单纯的为了耗时，来扩大时间差异
    private void timeElapsed() {
        for (int i = 0; i < 10000000; i++) {
            int a = new Random(100).nextInt(), b = new Random(100).nextInt();
            a = a + b;
        }
    }
}
