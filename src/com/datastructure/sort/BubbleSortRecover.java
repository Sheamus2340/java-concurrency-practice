package com.datastructure.sort;

/**
 * 冒泡排序：
 *  比较相邻两个数值，大的向右移动
 * Created by Sheamus on 2018/6/26.
 */
public class BubbleSortRecover {

    public static int[] bubbleSort(int[] arr) {
        for(int j = 0; j < arr.length; j++) {
            boolean flag = true;
            for(int i = 0; i < arr.length - 1; i++) {
                if(arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    flag = false;
                }
            }
            if(flag) {
                break;
            }
            System.out.println("第" + j + "次结果：");
            display(arr);
            System.out.println();
        }
        return arr;
    }

    private static void display(int[] arr) {
        for(int a : arr) {
            System.out.print(a + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {12,1,2,26,23,22};
        arr = BubbleSortRecover.bubbleSort(arr);
        display(arr);
    }

}
