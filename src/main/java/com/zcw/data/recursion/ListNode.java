package com.zcw.data.recursion;

/**
 * @ClassName : ListNode
 * @Description :
 * @Author : Zhaocunwei
 * @Date: 2020-07-28 11:14
 */
public class ListNode {
    public int val;
    public ListNode next;


    public ListNode(int x){
        val =x;
    }

    /**
     * 链表节点的构造函数
     * 使用Arr为参数，创建一个链表，当前的ListNode链表头结点
     * @param arr
     */
    public ListNode(int[] arr){
        if(arr == null || arr.length ==0){
            throw new IllegalArgumentException("arr can not be empty");
        }
        this.val =arr[0];
        ListNode cur = this;
        for(int i=1; i<arr.length;i++){
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        ListNode cur = this;
        while(cur !=null){
            res.append(cur.val + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
