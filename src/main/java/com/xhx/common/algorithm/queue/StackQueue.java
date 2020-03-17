package com.xhx.common.algorithm.queue;

import java.util.Stack;

/**
 * 栈实现的队列
 */
public class StackQueue {
    private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out = new Stack<>();

    private void transferIfEmpty() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
    }

    public void push(Integer n) {
        in.push(n);
    }

    public int pop() {
        transferIfEmpty();
        return out.pop();
    }

    public int peek() {
        transferIfEmpty();
        return out.peek();
    }

    public boolean isEmpty() {
        return in.isEmpty() && out.isEmpty();
    }
    public  static void main(String[] arg){
        StackQueue queue = new StackQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        queue.push(5);
        queue.push(6);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.isEmpty());
    }
}
