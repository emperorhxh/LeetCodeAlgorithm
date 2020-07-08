package com.xhx.common.algorithm.backtracing;
//Given a collection of distinct numbers, return all possible permutations.
//
//For example,
//[1,2,3] have the following permutations:
//[
  //[1,2,3],
  //[1,3,2],
  //[2,1,3],
  //[2,3,1],
  //[3,1,2],
  //[3,2,1]
//]

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<List<Integer>> res=new LinkedList<>();
        res.add(new ArrayList<>());
        for(int n:nums){
            int size = res.size();
            while (size >0 ){
                List<Integer> c=res.pollFirst();
                for(int i =0;i<=c.size();i++){
                    List<Integer> temp =new ArrayList<>(c);
                    temp.add(i,n);
                    res.add(temp);
                }
                size--;
            }
        }
        return res;
    }
}
