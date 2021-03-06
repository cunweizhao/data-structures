package com.zcw.data.array;

import org.omg.CORBA.Object;

/**
 * @ClassName : Array
 * @Description : 二次封装数组
 * @Author : Zhaocunwei
 * @Date: 2020-07-23 12:37
 */
public class Array<E>{
    private E[] data;
    private int size;


    /**
     * 构造函数，
     * 传入数组的容量capacity，构造Array
     * @param capacity
     */
    public Array(int capacity){
        data= (E[])new Object[capacity];
        size=0;
    }

    /**
     * 无参数的构造函数
     * 默认数组的容量为10
     */
    public Array(){
        this(10);
    }
    public Array(E[] arr){
        data =(E[])new Object[arr.length];
        for(int i=0;i<arr.length;i++){
            data[i]= arr[i];
        }
        size = arr.length;
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

    /**
     * 向数组最后添加一个新的元素
     * @param e
     */
    public void  addLast(E e){
//        if(size == data.length){
//            throw  new IllegalArgumentException("AddLast failed .Array is full.");
//        }
//        data[size] = e;
//        size ++;
        add(size,e);
    }

    public void addFirst(E e){
        add(0,e);
    }

    /**
     * 在第index 个位置插入一个新的元素e
     * @param index
     * @param e
     */
    public void add(int index,E e){
        if(size == data.length){
            throw new IllegalArgumentException("Add failed.Array is full.");
        }
        if(size == data.length){
            resize(2* data.length);
        }
        if(index <0 || index >size){
            throw new IllegalArgumentException("Add failed. Require inedex >=0  and index <=size");
        }
        for(int i = size-1; i>=index; i--){
            data[i+1] = data[i];
        }
        data[index] =e;
        size ++;
    }

    /**
     * 获取index索引位置的元素
     * @param index
     * @return
     */
    public E get(int index){
        if(index <0 || index >=size){
            throw  new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return  data[index];
    }

    /**
     * 修改index 索引位置的元素为e
     * @param index
     * @param e
     */
    public void set(int index, E e){
        if(index <0 || index >=size){
            throw new IllegalArgumentException();
        }
        data[index] = e;
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array:size= %d,capacity=%d\n",size,data.length));
        res.append('[');
        for(int i=0;i<size;i++){
            res.append(data[i]);
            if(i !=size-1){
                res.append(",");
            }
        }
        res.append(']');
        return res.toString();
    }

    /**
     * 查找数组中是否有元素e
     * @param e
     * @return
     */
    public boolean contains(E e){
        for(int i=0;i<size;i++){
            if(data[i].equals(e)){
                return true;
            }

        }
        return false;
    }

    /**
     * 查找数组中元素e的索引，
     * 如果不存在元素e,则返回-1
     * @param e
     * @return
     */
    public int find(E e){
        for(int i=0; i<size;i++){
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 从数组中删除index位置的元素
     * 返回删除的元素
     * @param index
     * @return
     */
    public E remove(int index){
        if(index<0 || index >=size){
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }
        E ret = data[index];
        for(int i=index +1;i<size; i++){
            data[i-1] = data[i];
        }
        size --;
        // loitering objects != memory leak
        data[size]=null;

        if(size == data.length/4 && data.length /2 !=0){
            resize(data.length/2);
        }
        return ret;
    }

    /**
     * 从数组中删除第一个元素，返回删除的元素
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 从数组中删除最后一个元素，
     * 返回删除的元素
     * @return
     */
    public E removeLast(){
        return remove(size -1);
    }

    /**
     * 从数组中删除元素e(只会删除一个)
     * @param e
     */
    public void removeElement(E e){
        int index = find(e);
        if(index !=-1){
            remove(index);
        }
    }
    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for(int i=0; i<size;i++){
            newData[i] =data[i];
        }
        data = newData;
    }

    public E getLast(){
        return get(size -1);
    }
    public E getFirst(){
        return get(0);
    }
    public void swap(int i, int j){
        if(i<0 || i>=size || j<0 || j>=size){
            throw new IllegalArgumentException("Index is illegal.");
        }
        E t = data[i];
        data[i] =data[j];
        data[j] =t;
    }
}
