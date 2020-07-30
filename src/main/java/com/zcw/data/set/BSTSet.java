package com.zcw.data.set;

import com.zcw.data.bst.BST;

import java.util.ArrayList;

/**
 * @ClassName : BSTSet
 * @Description :
 * @Author : Zhaocunwei
 * @Date: 2020-07-30 17:10
 */
public class BSTSet <E extends Comparable<E>> implements Set<E> {
    private BST<E> bst;

    public BSTSet(){
        bst = new BST<>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words1= new ArrayList<>();
        FileOperation.readFile("pride-and-prejudice.txt",words1);
        System.out.println("Total words:" +words1.size());

        BSTSet<String> set1 = new BSTSet<>();
        for(String word : words1){
            set1.add(word);
        }
    }
}
