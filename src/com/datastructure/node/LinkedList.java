package com.datastructure.node;

public class LinkedList {

    class Node {
        Object item;
        Node pre;
        Node next;
        public Node(Object item,Node pre,Node last) {
            item = item;
            pre = pre;
            last = last;
        }
    }

    int size;
    Node first;
    Node last;


    public boolean add(Object obj) {
        linkLast(obj);
        return true;
    }

    public boolean remove(Object o) {
        if (o == null) {
            for (Node x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    Object unlink(Node x) {
        // assert x != null;
        final Object element = x.item;
        final Node next = x.next;
        final Node prev = x.pre;

        //当前节点为first节点
        if (prev == null) {
            //删除这个节点时，要将next节点赋值为first节点
            first = next;
        } else {
            prev.next = next;
            x.pre = null;
        }

        //最后一个节点
        if (next == null) {
            last = prev;
        } else {
            next.pre = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        return element;
    }

    private void linkLast(Object obj) {
        //找到最后一个节点
        Node oldLast = last;
        //创建一个新的节点
        Node newLast = new Node(obj,oldLast,null);
        last = newLast;
        if(oldLast == null) {
            //表示也是第一个节点
            first = newLast;
        } else {
            //给原来的节点赋值下一个节点
            oldLast.next = newLast;
        }
        size++;
    }

}
