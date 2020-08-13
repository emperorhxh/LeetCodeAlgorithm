package com.xhx.common.algorithm.dynamicprogramming;

// There is a fence with n posts, each post can be painted with one of the k colors.

// You have to paint all the posts such that no more than two adjacent fence posts have the same color.

// Return the total number of ways you can paint the fence.

// Note:
// n and k are non-negative integers.

public class PaintFence {
    public int numWays(int n, int k) {
        if(n <= 0) {
            return 0;
        }
        
        int sameCount=0;
        int differentCount=k;
        for(int i=2;i<=k;i++){
            int temp = differentCount;
            differentCount=(sameCount+differentCount)*(k-1);
            sameCount=temp;
        }
        return sameCount+differentCount;
    }
}
