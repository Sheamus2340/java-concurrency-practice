package com.datastructure.node;

import java.util.Arrays;

public class ArrayList {
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    Object[] elementData;
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList() {
        elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public boolean add(Object obj) {
        ensureCapacityInternal(size + 1);  // Increments modCount!!
        elementData[size++] = obj;
        return true;
    }

    public Object remove(int index) {
        rangeCheck(index);

        Object oldValue = elementData[index];
        //需要移动的长度
        int numMoved = size - index - 1;
        //是正数才需要移动，否则不需要
        if (numMoved > 0)
            System.arraycopy(elementData, index+1, elementData, index,
                    numMoved);
        elementData[--size] = null; // clear to let GC do its work

        return oldValue;
    }

    private void rangeCheck(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException("ss");
    }

    private void ensureCapacityInternal(int minCapacity) {
        ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
    }

    /**
     * 计算容器的容量
     * @param elementData
     * @param minCapacity
     * @return
     */
    private static int calculateCapacity(Object[] elementData, int minCapacity) {
        //还没有初始化大小的时候
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            return Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        //直接取给定的容量
        return minCapacity;
    }

    private void ensureExplicitCapacity(int minCapacity) {
        // overflow-conscious code, 需要扩容
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }

    /**
     * 扩容
     * @param minCapacity
     */
    private void grow(int minCapacity) {
        // 当前容器的容量
        int oldCapacity = elementData.length;
        // 扩容后的大小，为现在的1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        //扩容后的大小小于给定的大小，那就将给定大小赋值给扩容的大小
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        //如果扩容的大小大于Integer的最大值减去8，那就进行进一步的扩容
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        // minCapacity is usually close to size, so this is a win:
        //只是单纯的增加大小
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE :
                MAX_ARRAY_SIZE;
    }

}
