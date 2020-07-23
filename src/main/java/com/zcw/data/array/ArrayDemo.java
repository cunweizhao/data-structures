package com.zcw.data.array;

/**
 * @ClassName : ArrayDemo
 * @Description : 数组
 * @Author : Zhaocunwei
 * @Date: 2020-07-23 12:01
 */
public class ArrayDemo {
    public static void main(String[] args) {
        //创建数组
        int [] arr = new int[20];
        for(int i=0;i<arr.length;i++){
            arr[i] =i;
        }
        int [] scores = new int[]{100,99,66};
        for(int i=0;i<scores.length;i++){
            System.out.println(scores[i]);
        }
        for (int score: scores) {
            System.out.println(score);
        }
    }
}
