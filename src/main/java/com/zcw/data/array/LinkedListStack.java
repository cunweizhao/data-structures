package com.zcw.data.array;

import com.zcw.data.likedlist.LinkedList;
import com.zcw.data.stack.ArrayStack;
import com.zcw.data.stack.Stack;

import java.util.Random;

/**
 * @ClassName : LinkedListStack
 * @Description :
 * @Author : Zhaocunwei
 * @Date: 2020-07-27 19:04
 */
public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> list;
    public LinkedListStack(){
        list = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: top");
        res.append(list);
        return res.toString();
    }

    /**
     * 测试使用stack运行opCount个push和pop操作所需要的时间，
     * 单位：秒
     */
    private static double testStack(Stack<Integer> stack,int  opCount){
        long startTime = System.nanoTime();
        Random random = new Random();

        for(int i=0; i<opCount;i++){
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for(int i=0;i<opCount;i++){
            stack.pop();
        }
        long endTIme =System.nanoTime();
        return (endTIme - startTime) /1000000000.0;
    }
    public static void main(String[] args) {
//        LinkedListStack<Integer> stack = new LinkedListStack<>();
//        for(int i=0;i<5;i++){
//            stack.push(i);
//            System.out.println(stack);
//        }
//        stack.pop();
//        System.out.println(stack);
        int opCount = 100000;
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time1 = testStack(arrayStack,opCount);
        System.out.println("ArrayStack, time:" + time1 +"s");

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double time2 = testStack(linkedListStack,opCount);
        System.out.println("LinkedListStack,time:"+time2+"s");

        //其实这个时间比较复杂，因为LinkedListStack中包含更多的new操作
    }
}
