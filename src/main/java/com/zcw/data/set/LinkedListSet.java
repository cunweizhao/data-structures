package com.zcw.data.set;

import com.zcw.data.likedlist.LinkedList;

/**
 * @ClassName : LinkedListSet
 * @Description : 基于链表的集合类
 * @Author : Zhaocunwei
 * @Date: 2020-07-30 18:01
 */
public class LinkedListSet<E> implements Set<E>{
    private LinkedList<E> list;

    public LinkedListSet(){
        list =new LinkedList<>();
    }

    @Override
    public void add(E e) {
        if(!list.constains(e)){
            list.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return list.constains(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
