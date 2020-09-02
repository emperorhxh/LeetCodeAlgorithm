package com.xhx.common.algorithm.link;
// Reverse a singly linked list.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (null == head || head.next == null) return head;
        ListNode current = head;
        ListNode pre = null;

        while (current !=null){
            ListNode next = current.next ;
            current.next=pre;
            pre=current;
            current=next;
        }
        return pre;
    }
}
