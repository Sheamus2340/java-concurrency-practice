package com.datastructure.tree;

/**
 * Created by Sheamus on 2018/6/25.
 */
public class TreeTest {
    //中序遍历
    public void infixOrder(Node current){
        if(current != null){
            infixOrder(current.leftChild);
            System.out.print(current.data+" ");
            infixOrder(current.rightChild);
        }
    }

    public static void main(String[] args) {

    }
}
