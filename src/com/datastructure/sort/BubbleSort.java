package com.datastructure.sort;

/**
 * 冒泡排序
 * 　　冒泡算法的运作规律如下：
 　　①、比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 　　②、对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数（也就是第一波冒泡完成）。
 　　③、针对所有的元素重复以上的步骤，除了最后一个。
 　　④、持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 * Created by Sheamus on 2018/6/25.
 */
public class BubbleSort {

    public int[] bubbleSort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            //设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
            boolean flag = true;
            for (int j = 0; j < (arr.length - i); j++) {
                if (arr[j] > arr[j + 1]) {
                    //交换数值
                    swap(j, j + 1, arr);
                    flag = false;
                }
            }
            if(flag) {
                break;
            }
            //第 i轮排序的结果为
            System.out.print("第"+i+"轮排序后的结果为:");
            display(arr);
        }
        return arr;
    }

    private void display(int[] arr) {
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    private void swap(int i, int j, int[] arr) {
        rangeCheck(i,arr);rangeCheck(j,arr);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void rangeCheck(int index, int[] arr) {
        if (index < 0 || index >= arr.length)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index, arr));
    }

    private String outOfBoundsMsg(int index, int[] arr) {
        return "Index: " + index + ", Size: " + arr.length;
    }

    public static void main(String[] args) {
        //int[] arr = {10,1,3,4,5,6,12,4,23,44,11};
        int[] arr = {4,2,8,9,5,7,6,1,3};
        BubbleSort sort = new BubbleSort();
        arr = sort.bubbleSort(arr);
        sort.display(arr);
    }
}
