package com.zcw.data.segmentTree;

/**
 * @ClassName : SegmentTree
 * @Description :
 * @Author : Zhaocunwei
 * @Date: 2020-08-21 13:18
 */
public class SegmentTree<E> {
    private E[] data;
    private E[] tree;
    public SegmentTree(E[] arr){
        data =(E[]) new Object[arr.length];
        for(int i=0;i<arr.length;i++){
            data[i] =arr[i];
        }
        tree =(E[])new Object[ 4 * arr.length];
    }
    public int getSize(){
        return data.length;
    }
    public E get(int index){
        if(index <0 || index >=data.length){
            throw new IllegalArgumentException("index is illegal.");
        }
        return data[index];
    }
    //返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index){
        return 2 * index +1;
    }
    //返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index){
        return 2 * index + 2;
    }
}
