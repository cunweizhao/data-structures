package com.zcw.data.recursion;

/**
 * @ClassName : Solution3
 * @Description :
 * @Author : Zhaocunwei
 * @Date: 2020-07-28 14:02
 */
public class Solution3 {
    public ListNode removeElements(ListNode head ,int val){
        if(head == null){
            return null;
        }
        //第一种写法
//        ListNode res = removeElements(head.next,val);
//        if(head.val == val){
//            return res;
//        }else{
//            head.next = res;
//            return head;
//        }
        //第二种写法
        head.next = removeElements(head.next,val);
        return head.val == val ? head.next:head;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,6,3,4,5,6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res =(new Solution3()).removeElements(head,6);
        System.out.println(res);
    }
}
