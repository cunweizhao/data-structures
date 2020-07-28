package com.zcw.data.recursion;

/**
 * @ClassName : Solution
 * @Description :
 * @Author : Zhaocunwei
 * @Date: 2020-07-28 11:13
 */
public class Solution {
    public ListNode removeElements(ListNode head,int val){
        while (head !=null && head.val == val){
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }
       if(head == null){
           return  null;
       }


       ListNode prev = head;
       while(prev.next !=null){
           if(prev.next.val == val){
               ListNode delNode = prev.next;
               prev.next = delNode.next;
               delNode.next = null;
           }else{
               prev = prev.next;
           }
       }
       return head;
    }
}
