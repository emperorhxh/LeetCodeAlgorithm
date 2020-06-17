package com.xhx.common.algorithm.array;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicatesII {
    /**
     * //Given an array of integers and an integer k, find out whether there are two distinct indices i and
     * //j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int c = nums[i];
            if(map.containsKey(c)&&i-map.get(c)<=k){
                return true;
            }else {
                map.put(c,i);
            }
        }
        return false;
    }
}
