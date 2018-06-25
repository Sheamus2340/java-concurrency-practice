package com.datastructure.sort;

/**
 * 插入排序：
 * 直接插入排序基本思想是每一步将一个待排序的记录，插入到前面已经排好序的有序序列中去，直到插完所有元素为止。
 　插入排序还分为
        直接插入排序、二分插入排序、链表插入排序、希尔排序等等，
   这里我们只是以直接插入排序讲解，后面讲高级排序的时候会将其他的。
 * Created by Sheamus on 2018/6/25.
 */
public class InsertSort {

    public int[] insertSort(int[] arr) {
        int j = 0;
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];//记录要插入的数据
            j = i;//保存要插入数据的地方
            while(j > 0 && temp < arr[j - 1]) {//寻找到要插入的位置,找打小于要比较的值的地方
                //移动位置
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;//存在比其小的数，插入
        }
        return arr;
    }

    private void display(int[] arr) {
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {4,2,8,9,5,7,6,1,3};
        InsertSort sort = new InsertSort();
        arr = sort.insertSort(arr);
        sort.display(arr);
    }
}
