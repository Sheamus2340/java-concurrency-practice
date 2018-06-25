package com.jdk8.level02;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义对象的key一定要重写hashcode方法，和equals方法
 * Created by Sheamus on 2018/6/21.
 */
public class MapTest {
    static class Person {
        String name;
        int age;
        private int hash;

        public Person() {
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public int hashCode() {
            int h = hash;
            if (h == 0 && name.toCharArray().length > 0) {
                char val[] = name.toCharArray();

                for (int i = 0; i < name.toCharArray().length; i++) {
                    h = 31 * h + val[i] + age;
                }
                hash = h;
            }
            return h;
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj) {
                return true;
            }
            if(obj == null || !(obj instanceof Person)) {
                return false;
            }
            Person other = (Person)obj;
            if(this.name.equals(other.name) && this.age == other.age) {
                return true;
            }
            return false;
        }

        @Override
        public String toString() {
            return "name : " + name + ", age : " + age;
        }
    }

    public static void main(String[] args) {

        Map<Person,String> map = new HashMap<>(5);
        for (int i = 0; i < 15; i++) {
            Person zhangsan = new Person("zhangsan" + i,3 * i);
            map.put(zhangsan,"zhangsan" + i);
        }

        AtomicInteger i = new AtomicInteger(0);

        Set<Person> people = map.keySet();
        for(Person person : people) {
            i.getAndIncrement();
            System.out.println(i.get());
            System.out.println(person);
            System.out.println(map.get(person));
        }
    }

}
