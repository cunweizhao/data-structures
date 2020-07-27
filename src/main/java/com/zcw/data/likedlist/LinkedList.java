package com.zcw.data.likedlist;

/**
 * @ClassName : LinkedList
 * @Description :
 * @Author : Zhaocunwei
 * @Date: 2020-07-27 15:34
 */
public class LinkedList<E> {
    private class Node{
        public E e;
        public Node next;

        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }
        public Node(E e){
            this(e,null);
        }
        public Node(){
            this(null,null);
        }
        @Override
        public String toString(){
            return e.toString();
        }
    }
}
