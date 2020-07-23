package com.zcw.data;

import com.zcw.data.array.Array;

/**
 * @ClassName : Main
 * @Description :
 * @Author : Zhaocunwei
 * @Date: 2020-07-23 13:50
 */
public class Main {
    public static void main(String[] args) {
        Array array = new Array(20);
        for(int i=0;i<10;i++){
            array.addLast(i);
        }
        System.out.println(array);
        array.add(1,100);
        System.out.println(array);


        array.addFirst(-1);
        System.out.println(array);
    }
}
