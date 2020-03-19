package com.xhx.common.algorithm.num;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 数据流的中位数
 * 实现它的addNum和findMedia方法
 */
public class MediaFinder {
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    /**
     * 添加元素
     * @param n
     */
    public void addNum(int n){
        maxHeap.add(n);
        minHeap.add(maxHeap.poll());
        if(maxHeap.size() < minHeap.size()){
            maxHeap.add(minHeap.poll());
        }
    }

    /**
     * 查找中位数
     *
     * @return
     */
    public int findMedia(){

        if(maxHeap.size() == minHeap.size()){
            return (maxHeap.peek()+minHeap.peek())/2;
        }else {
            return maxHeap.peek();
        }
    }
}
