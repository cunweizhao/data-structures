package com.zcw.data;

import com.zcw.data.array.Array;
import com.zcw.data.stack.ArrayStack;

/**
 * @ClassName : Main
 * @Description :
 * @Author : Zhaocunwei
 * @Date: 2020-07-23 13:50
 */
public class Main {
    public static void main(String[] args) {
//        Array<Integer> array = new Array(20);
//        for(int i=0;i<10;i++){
//            array.addLast(i);
//        }
//        System.out.println(array);
//        array.add(1,100);
//        System.out.println(array);
//
//
//        array.addFirst(-1);
//        System.out.println(array);



        ArrayStack<Integer> stack = new ArrayStack<>();
        for(int i=0; i<5; i++){
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }
}
