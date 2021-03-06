package com.zcw.data.queue;

import com.zcw.data.array.Array;

/**
 * @ClassName : ArrayQueue
 * @Description :
 * @Author : Zhaocunwei
 * @Date: 2020-07-27 13:07
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;
    public ArrayQueue(int capacity){
        array = new Array<>(capacity);
    }
    public ArrayQueue(){
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }
    @Override
    public E dequeue() {
        return array.removeLast();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    public int getCapacity(){
        return array.getCapacity();
    }
}
