package com.xhx.common.algorithm.link;

import java.util.Random;

public class Node {
    private int value;
    private Node next;
    public Node(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
    public void setValue(int value){
        this.value=value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    /**
     * 获取一个随机的node
     * @param size
     * @return
     */
    public static Node getNode(int size){
        Node origin =new Node(5);
        Node current =origin;
        for(int i = 0;i<size-1;i++){
            Random random = new Random();
            int e= random.nextInt(10);
            Node next =new Node(10+e);
            current.next = next;
            current = next;
        }
        return origin;
    }

    /**
     * 转换数组为node
     * @param arr
     * @return
     */
    public static Node getNode(int[] arr){
        Node origin =new Node(arr[0]);
        Node current =origin;
        for(int i = 1;i<arr.length;i++){
            Node next =new Node(arr[i]);
            current.next = next;
            current = next;
        }
        return origin;
    }


    public void print(){
        Node node=this;

        while (null != node){
            System.out.print(node.value);
            node = node.next;
            if(null != node)
                System.out.print(",");
        }
        System.out.println("");
    }
}
