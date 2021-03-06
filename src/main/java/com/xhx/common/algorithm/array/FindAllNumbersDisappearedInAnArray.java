package com.xhx.common.algorithm.array;//Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
//
//Find all the elements of [1, n] inclusive that do not appear in this array.
//
//Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
//
//Example:
//
//Input:
//[4,3,2,7,8,2,3,1]
//
//Output:
//[5,6]

import java.util.*;

class FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
        List<Integer> res = findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
        for (int a:res){
            System.out.print(a);
        }
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res=new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i< nums.length;i++){
            map.put(nums[i],i);
        }
        for (int i=1;i<= nums.length;i++){
            if(!map.containsKey(i)){
                res.add(i);
            }
        }
        return res;
    }
}
