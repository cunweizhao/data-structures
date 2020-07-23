package com.zcw.data.array;

/**
 * @ClassName : Array
 * @Description : 二次封装数组
 * @Author : Zhaocunwei
 * @Date: 2020-07-23 12:37
 */
public class Array {
    private int[] data;
    private int size;


    /**
     * 构造函数，
     * 传入数组的容量capacity，构造Array
     * @param capacity
     */
    public Array(int capacity){
        data= new int[capacity];
        size=0;
    }

    /**
     * 无参数的构造函数
     * 默认数组的容量为10
     */
    public Array(){
        this(10);
    }

    //获取数组中的元素的个数
    public int getSize(){
        return size;
    }
    //获取数组的容量
    public int getCapacity(){
        return data.length;
    }

    public boolean isEmpty(){
        return size==0;
    }
}
