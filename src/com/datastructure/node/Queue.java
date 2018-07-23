package com.datastructure.node;

/**
 * Created by Sheamus on 2018/6/29.
 */
public class Queue {
    private int front;
    private int end;
    private int[] value;
    private int size;//实际大小

    public Queue(int capcity) {
        value = new int[capcity];
    }
}
