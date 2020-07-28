package com.zcw.data.bst;

/**
 * @ClassName : BST
 * @Description :二分搜索树
 * @Author : Zhaocunwei
 * @Date: 2020-07-28 18:37
 */
public class BST<E extends Comparable<E>> {

    private class Node{
        public E e;
        public Node left,right;

        public Node(E e){
            this.e = e;
            left = null;
            right =null;
        }
    }
    private Node root;
    private int size;

    public BST(){
        root =null;
        size =0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
}
