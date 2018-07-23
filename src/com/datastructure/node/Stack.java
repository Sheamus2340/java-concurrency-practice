package com.datastructure.node;

/**
 * Created by Sheamus on 2018/6/29.
 */
public class Stack {
    private int[] value;
    private int top = -1;
    private int size = 0;

    public Stack(int capacity) {
        value = new int[capacity];
    }

    public void add(int num) throws Exception {
        if(size >= value.length) {
            throw new Exception("扩容把！");
        }
        value[++top] = num;
        size++;
    }

    public int remove() throws Exception {
        if(size == 0) {
            throw new Exception("没有元素！");
        }
        int key = value[top--];
        size--;
        return key;
    }

    public static void main(String[] args) throws Exception {
        Stack stack = new Stack(5);
        stack.add(10);
        stack.add(12);
        stack.add(13);
        stack.add(14);
        stack.add(15);

        System.out.println(stack.remove());
        System.out.println(stack.remove());
        System.out.println(stack.remove());
        System.out.println(stack.remove());
        System.out.println(stack.remove());
    }

}
