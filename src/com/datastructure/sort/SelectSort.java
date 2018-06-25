package com.datastructure.sort;

/**
 * 选择排序
 *选择排序是每一次从待排序的数据元素中选出最小的一个元素，存放在序列的起始位置，直到全部待排序的数据元素排完。

 　　分为三步：
 　　①、从待排序序列中，找到关键字最小的元素
 　　②、如果最小元素不是待排序序列的第一个元素，将其和第一个元素互换
 　　③、从余下的 N - 1 个元素中，找出关键字最小的元素，重复(1)、(2)步，直到排序结束
 * Created by Sheamus on 2018/6/25.
 */
public class SelectSort {

    public int[] selectSort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            int min = min(i,arr.length,arr);
            if(i != min) {
                //交换数值
                swap(i,min,arr);
            }
            System.out.println("第" + i + "次交换的结果：");
            display(arr);
        }
        return arr;
    }

    private void swap(int i, int min, int[] arr) {
        rangeCheck(i,arr);rangeCheck(min,arr);
        int temp = arr[i];
        arr[i] = arr[min];
        arr[min] = temp;
    }

    private void rangeCheck(int index, int[] arr) {
        if (index < 0 || index >= arr.length)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index, arr));
    }

    private String outOfBoundsMsg(int index, int[] arr) {
        return "Index: " + index + ", Size: " + arr.length;
    }

    /**
     * 返回最小值的下标
     * @param i
     * @param length
     * @param arr
     * @return
     */
    private int min(int i, int length, int[] arr) {
        int min = i;
        int minData = arr[i];
        for(int j = i + 1; j < length; j++) {
            if(arr[j] < minData) {
                min = j;
                minData = arr[j];
            }
        }
        return min;
    }

    private void display(int[] arr) {
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {4,2,8,9,5,7,6,1,3};
        SelectSort sort = new SelectSort();
        arr = sort.selectSort(arr);
        sort.display(arr);
    }
}
