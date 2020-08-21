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
    private Merger<E> merger;

    public SegmentTree(E[] arr,Merger<E> merger){

        this.merger = merger;

        data =(E[]) new Object[arr.length];
        for(int i=0;i<arr.length;i++){
            data[i] =arr[i];
        }
        tree =(E[])new Object[ 4 * arr.length];

        buildSegmentTree(0,0,data.length-1);
    }

    /**
     * 在treeIndex的位置创建表示区间[l....r]的线段树
     * @param treeIndex
     * @param l
     * @param r
     */
    private void buildSegmentTree(int treeIndex,int l,int r){
        if( l== r){
            tree[treeIndex] =data[l];
            return;
        }
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        int mid = l + (r-l) /2;
        buildSegmentTree(leftTreeIndex,l,mid);
        buildSegmentTree(rightTreeIndex,mid+1,r);

        tree[treeIndex] = merger.merge(tree[leftTreeIndex] ,tree[rightTreeIndex]);
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
