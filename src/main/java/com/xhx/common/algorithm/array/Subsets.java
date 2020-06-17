package com.xhx.common.algorithm.array;// Given a set of distinct integers, nums, return all possible subsets.

// Note: The solution set must not contain duplicate subsets.

// For example,
// If nums = [1,2,3], a solution is:

// [
//   [3],
//   [1],
//   [2],
//   [1,2,3],
//   [1,3],
//   [2,3],
//   [1,2],
//   []
// ]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Subsets {
    public static void main(String[] args) {
        List<List<Integer>> res = subsets(new int[]{1,2,3,4,5});
        for(List<Integer> list:res){
            for (Integer i:list){
                System.out.print(i);
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        recurse(result, nums, new Stack<>(), 0);

        return result;
    }

    private static void recurse(List<List<Integer>> result, int[] nums, Stack path, int position) {
        if(position == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        path.push(nums[position]);

        recurse(result, nums, path, position + 1);

        path.pop();

        recurse(result, nums, path, position + 1);
    }

}
