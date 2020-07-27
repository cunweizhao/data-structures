package com.zcw.data.queue;

/**
 * @ClassName : LoopQueue
 * @Description : 循环数组
 * @Author : Zhaocunwei
 * @Date: 2020-07-27 14:02
 */
public class LoopQueue<E> implements Queue<E>{

    private E[] data;
    private int front,tail;
    private int size;

    public LoopQueue(int capacity){
        data = (E[])new Object[capacity +1];
        front =0;
        tail =0;
        size=0;
    }

    public LoopQueue(){
        this(10);
    }

    public int getCapacity(){
        return data.length -1;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void enqueue(E e) {

    }

    @Override
    public E dequeue() {
        return null;
    }

    @Override
    public E getFront() {
        return null;
    }
}
