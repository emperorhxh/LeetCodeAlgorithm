package com.xhx.common.algorithm.array;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] arr =new int[]{7, 1, 5, 3, 6, 4};
        int max =maxProfit(arr);
        System.out.print(max);
    }
    public static int maxProfit(int[] prices){
        if(prices.length==0) return 0;
        int min=prices[0];
        int max = 0;
        for (int i=0;i<prices.length;i++){
            if(prices[i]>min){
                max=Math.max(max,prices[i]-min);
            }else {
                min=prices[i];
            }
        }
        return max;
    }
}
