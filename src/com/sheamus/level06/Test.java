package com.sheamus.level06;

/**
 * Created by Sheamus on 2018/6/15.
 */
public class Test {

        static int a;
        int b;
        static int c;

        public int aMethod() {
            a++;
            return a;
        }

        public int bMethod() {
            b++;
            return b;
        }

        public static int cMethod() {
            c++;
            return c;
        }

        /*public static void main(String args[]) {
            Test test1 = new Test();
            test1.aMethod();
            System.out.println(test1.aMethod());
            Test test2 = new Test();
            test2.bMethod();
            System.out.println(test2.bMethod());
            Test test3 = new Test();
            test3.cMethod();
            System.out.println(test3.cMethod());

            String str = null;
            str.concat("abc");
            str.concat("123");
            System.out.println(str);
            System.out.println(93&-8);
        }*/

    static int cnt = 0;
    public static void main(String[] args) {
        fib(7);
        System.out.println(cnt);
    }
    static int fib(int n) {
        cnt++;
        if (n == 0)
            return 1;
        else if (n == 1)
            return 2;
        else
            return fib(n - 1) + fib(n - 2);
    }

   /* int count = 21;
    public void count() {
        System.out.println(++count);
    }
    public static void main(String args[]) {
        new Test().count();
        new Test().count();
    }*/

}
