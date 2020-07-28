package com.zcw.data.recursion;

/**
 * @ClassName : Solution2
 * @Description :虚拟节点
 * @Author : Zhaocunwei
 * @Date: 2020-07-28 12:07
 */
public class Solution2 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;


        ListNode prev = dummyHead;
        while (prev.next != null) {
                if (prev.next.val == val) {
                    prev.next = prev.next.next;
                } else {
                    prev = prev.next;
                }

        }
        return dummyHead.next;
    }
}
