package com.xhx.common.algorithm.link;
// Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null||lists.length==0) {
            return null;
        }
        PriorityQueue<ListNode> queue=new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        ListNode head=new ListNode(0);
        ListNode tail=head;
        for(ListNode node:lists){
            queue.add(node);
        }

        while (!queue.isEmpty()){
            ListNode node=queue.poll();
            tail.next=node;
            tail=tail.next;
            if(tail.next!=null){
                queue.add(tail.next);
            }
        }
        tail.next=null;
        return head.next;

    }
}
