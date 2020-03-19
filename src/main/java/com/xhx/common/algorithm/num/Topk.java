package com.xhx.common.algorithm.num;

import java.util.*;

/**
 * 前 K 个高频元素
 */
public class Topk {

    /**
     * 使用最小堆算法
     * 第一步，统计每个数的频次，放入map
     * 第二步，遍历map，依次放入有序队列，队列的长度大于k后如果新插入的数据的频次大于队尾的元素，则删除后再加入
     * @param k
     * @return
     */
    public static List<Integer> top1(int[] arr, int k){
        Map<Integer,Integer> map =new HashMap<>();

        for(int a:arr){
            if(map.containsKey(a)){
                map.put(a,map.get(a)+1);
            }else {
                map.put(a,1);
            }
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1)-map.get(o2);
            }
        });

        for(Integer a:map.keySet()){
            if(queue.size()<k){
                queue.add(a);
            }else if(map.get(a) > map.get(queue.peek())){
                queue.remove();
                queue.add(a);
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()){
            res.add(queue.poll());
        }
        return res;

    }

    /**
     * 使用桶排序算法
     * @param k
     * @return
     */
    public static List<Integer> top2(int[] arr, int k){
        Map<Integer,Integer> map =new HashMap<>();

        for(int a:arr){
            if(map.containsKey(a)){
                map.put(a,map.get(a)+1);
            }else {
                map.put(a,1);
            }
        }

        List<Integer>[] list=new List[arr.length+1];

        for(Integer a:map.keySet()){
            Integer index = map.get(a);
            if(list[index] ==null){
                list[index] = new ArrayList<>();
                list[index].add(a);
            }else {
                list[index].add(a);
            }
        }
        List<Integer> res=new ArrayList<>();
        for (int i=list.length-1;i>=0&& res.size()<k;i--){
            if(list[i] == null)
                continue;
            res.addAll(list[i]);
        }
        return res;

    }

    public  static void main(String[] arg){
        List<Integer> res = top1(new int[]{1,1,1,2,2,3,3,3},2);
        res.forEach(a -> System.out.println(a));

    }
}
