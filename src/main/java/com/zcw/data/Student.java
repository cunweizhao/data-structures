package com.zcw.data;

import com.zcw.data.array.Array;

/**
 * @ClassName : Student
 * @Description :
 * @Author : Zhaocunwei
 * @Date: 2020-07-23 15:10
 */
public class Student {
    private String name;
    private int score;
    public Student(String studentName,int studentScore){
        this.name = studentName;
        this.score = studentScore;
    }
    @Override
    public String toString(){
        return String.format("Student(name:%s,score:%d",name,score);
    }

    public static void main(String[] args) {
        Array<Student> arr= new Array<>();
        arr.addLast(new Student("Alice",100));
        arr.addLast(new Student("Bob",66));
        arr.addLast(new Student("Charlie",88));
        System.out.println(arr);
    }
}
