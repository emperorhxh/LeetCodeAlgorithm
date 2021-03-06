package com.xhx.common.algorithm.link;

import java.util.Deque;
import java.util.LinkedList;

public class Link {


    /**
     * 一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
     * 1、链表至少包含两个节点。
     * 2、链表中所有节点的值都是唯一的。
     * 3、给定的节点为非末尾节点并且一定是链表中的一个有效节点。
     * 4、不要从你的函数中返回任何结果。
     * @param node
     */
    public static void deleteNode(Node node,int n) {

        Node current =node;
        while (null != current){
            if(current.getValue() == n){
                current.setValue(current.getNext().getValue());
                current.setNext(current.getNext().getNext());
            }
            current = current.getNext();
        }
    }

    /**
     * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。
     * 返回滑动窗口最大值。
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
       if(nums.length <k ||k==0) return new int[0];
       int[] res = new int[nums.length-k+1];
       Deque<Integer> deque=new LinkedList<>();
       for(int i=0;i<nums.length;i++){
           while (!deque.isEmpty() && nums[deque.getLast()] <nums[i]){
               deque.removeLast();
           }
           deque.add(i);
           if(deque.getFirst() <= i-k){
               deque.removeFirst();
           }
           if(i>=k-1){
               res[i-k+1]=nums[deque.getFirst()];
           }
       }
        return res;
    }

    /**
     * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
     * @param node
     * @return
     */
    public static Node oddEventList(Node node){
        if(null == node) return node;
        int index = 1;
        Node node1Head = node,tail1= node;
        Node node2Head = node.getNext(),tail2=node2Head;
        if(null == node2Head ) return node;
        Node cur = tail2.getNext();
        while (cur != null){
            if(index % 2 == 1){
                tail1.setNext(cur);
                tail1 = cur;

            }else {
                tail2.setNext(cur);
                tail2 = cur;
            }
            cur =cur.getNext();
            index++;
        }
        tail2.setNext(null);

        tail1.setNext(node2Head);

        return node1Head;
    }


    public  static void main(String[] arg){
        Node node =Node.getNode(10);
        node.print();
        node = oddEventList(node);
        node.print();

    }
}
