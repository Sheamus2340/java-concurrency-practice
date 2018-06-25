package com.jdk8.level01;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Sheamus on 2018/6/20.
 */
public class CollectionsTest {
    public static void main(String[] args) {

        List<Apple> inventory = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Weight weight = new Weight(i * 100);
            Apple aapple = new Apple(weight,"zhang" + i);
            inventory.add(aapple);
        }

        // ---- before ----
        /*Collections.sort(inventory, new Comparator<Apple>() {
            public int compare(Apple a1, Apple a2){
                return a1.getWeight().compareTo(a2.getWeight());
            }
        });*/

        // ---- after ----
        inventory = filterApples(inventory, (Apple a) -> a.getWeight().getWe() > 150 );

        for (Apple a : inventory) {
            System.out.println(a.getName());
        }

    }

    static List<Apple> filterApples(List<Apple> inventory,
                                    Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory){
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }


    static class Apple {
        String name;
        Weight weight;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Weight getWeight() {
            return weight;
        }

        public void setWeight(Weight weight) {
            this.weight = weight;
        }

        public Apple() {

        }

        public Apple(Weight weight,String name) {
            this.weight = weight;
            this.name = name;
        }

    }

    static class Weight implements Comparable<Weight>{

        int we;

        public int getWe() {
            return we;
        }

        public void setWe(int we) {
            this.we = we;
        }

        public Weight(int we) {
            this.we = we;
        }

        @Override
        public int compareTo(Weight w) {
            if(we > w.getWe()) {
                return -1;
            } else if(we < w.getWe()) {
                return 1;
            }
            return 0;
        }
    }

}
