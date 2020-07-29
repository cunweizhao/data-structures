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
    /**
     * 向二分搜索树中添加新的元素e
     */
    public void add(E e){
//        if(root == null){
//            root = new Node(e);
//            size ++;
//        }else{
//            add(root,e);
//        }
        root = add(root,e);
    }
    /**
     *向以node为根的二分搜索树中插入元素E，递归算法
     */
//    private void add(Node node ,E e){
//        if(e.equals(node.e)){
//            return;
//        }else if(e.compareTo(node.e) <0  && node.left ==null){
//            node.left = new Node(e);
//            size++;
//            return;
//        }else if(e.compareTo(node.e) >0 && node.right ==null){
//            node.right = new Node(e);
//            size++;
//            return;
//        }
//
//        if(e.compareTo(node.e)<0){
//            add(node.left,e);
//        }else{
//            add(node.right,e);
//        }
//    }

    /**
     * 改进添加操作： 深入理解递归终止条件
     * 返回出入新节点后二分搜索树的根
     * @param node
     * @param e
     * @return
     */
    private Node add(Node node ,E e){
        if(node == null){
            size++;
            return new Node(e);
        }
        if(e.compareTo(node.e)<0){
            node.left = add(node.left,e);
        }else if(e.compareTo(node.e) >0){
           node.right = add(node.right,e);
        }
        return node;
    }
    /**
     * 看二分搜索树中是否包含元素e
     */
    public boolean contains(E e){
        return contains(root,e);
    }

    /**
     * 看以node为根的二分搜索树中是否包含元素e,递归算法
     * @param node
     * @param e
     * @return
     */
    private boolean contains(Node node ,E e){
        if(node == null){
            return  false;
        }
        if(e.compareTo(node.e) == 0){
            return  true;
        }else  if(e.compareTo(node.e) < 0){
            return contains(node.left,e);
        }else{
            return contains(node.right,e);
        }
    }
}