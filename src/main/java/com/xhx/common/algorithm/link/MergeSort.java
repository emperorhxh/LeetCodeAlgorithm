package com.xhx.common.algorithm.link;

/**
 * 给定一个Int的链表，要求在时间最优的情况下完成链表元素由大到小的排序，
 * e.g: 1->5->4->3->2
 * 排序后结果 5->4->3->2->1
 */
public class MergeSort {

    public Node sortMerge(Node node){
        int count =0;
        Node temp=node;
        while (temp != null){
            count++;
            temp=temp.getNext();
        }
        if(count == 1){
            return node;
        }

        int middle = count/2;
        Node left = node;
        Node t=node;
        count =0;
        while (t != null && count < middle-1){
            count++;
            t=t.getNext();
        }
        Node right = t.getNext();
        t.setNext(null);
        left = sortMerge(left);
        right = sortMerge(right);
        return mergeTwo(left,right);

    }

    public Node mergeTwo(Node left,Node right){
        Node res = new Node(0);
        Node head = res;
        while (null != left && null != right){
            if(left.getValue() > right.getValue()){
                res.setNext(left);
                left=left.getNext();

            }else {
                res.setNext(right);
                right=right.getNext();
            }
            res=res.getNext();
        }

        if(null != left) res.setNext(left);
        if(null != right) res.setNext(right);

        return head.getNext();
    }

    public static void main(String[] args) {
        MergeSort sort=new MergeSort();
        Node node=Node.getNode(5);
        node.print();
        Node n=sort.sortMerge(node);
        n.print();
    }

}
