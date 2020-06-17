package com.xhx.common.algorithm.array;
// Given a sorted integer array where the range of elements are in the inclusive range [lower, upper], return its missing ranges.

// For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].

import java.util.*;

public class MissingRanges {
    public static void main(String[] args) {
        List<String> res = findMissingRanges(new int[]{0, 1, 3, 50, 75},0,99);
        for (String re:res){
            System.out.println(re);
        }

    }
    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res=new ArrayList<>();


        int i=0;
        while (nums[i]<lower && i<nums.length){
            i++;
        }
        Set<Integer> set=new HashSet<Integer>();
        for(int num:nums){
            set.add(num);
        }
        int start = -1;
        int end = -1;
        for (int j = lower;j<=upper;j++){
            if(set.contains(j)){
                if(start != -1){
                    if(end ==-1){
                        res.add(start+"");
                        start=-1;
                    }else {
                        res.add(start+"->"+end);
                        start=-1;
                        end=-1;
                    }
                }
            }else {
                if(start == -1){
                    start=j;
                }else {
                    end=j;
                }
            }
        }

        if(start != -1){
            if(end ==-1){
                res.add(start+"");
                start=-1;
            }else {
                res.add(start+"->"+end);
                start=-1;
                end=-1;
            }
        }
        return res;
    }

}
