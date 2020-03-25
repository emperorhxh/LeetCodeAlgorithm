package com.xhx.common.algorithm.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 求两个数组交集
 *
 */
public class TwoMixed {


    /**
     * 给定两个数组，编写一个函数来计算它们的交集。
     * @param arr1
     * @param arr2
     * @return
     */
    private static List<Integer> mixed(int[] arr1, int[] arr2){
        Set<Integer> set=new HashSet<>();
        for (int i:arr1){
            set.add(i);

        }

        Set<Integer> res = new HashSet<>();
        for(int i:arr2){
            if(set.contains(i)){
                res.add(i);
            }
        }
        return new ArrayList<>(res);
    }

    /**
     * 如果给定的数组已经排好序呢？你将如何优化你的算法？假如降序排列
     * @param arr1
     * @param arr2
     * @return
     */
    private static List<Integer> mixedOrdered(int[] arr1, int[] arr2){
        Set<Integer> res = new HashSet<>();
        int i=0,j=0;
        while (i<arr1.length && j<arr2.length){
            if(arr1[i] == arr2[j]){
                res.add(arr1[i]);
                i++;
                j++;
            }else if(arr1[i] > arr2[j]){
                i++;
            }else{
                j++;
            }
        }

        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        List<Integer> res = mixedOrdered(new int[]{10,9,5,3},new int[]{9,8,4,3,2});
        for (int i:res){
            System.out.println(i);
        }
    }
}
