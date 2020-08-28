package com.xhx.common.algorithm.greedy;


//Say you have an array for which the ith element is the price of a given stock on day i.
//Design an algorithm to find the maximum profit. You may complete as many transactions as you 
//like (ie, buy one and sell one share of the stock multiple times). However, you may not engage 
//in multiple transactions at the same time (ie, you must sell the stock before you buy again).

/**
 * 可以买2次
 */
class BestTimeToBuyAndSellStockII3 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        
        int buy1 = Integer.MIN_VALUE,sell1=0;
        int buy2 = Integer.MIN_VALUE,sell2=0;
        for(int i = 0; i < prices.length ; i++) {
            buy1=Math.max(buy1,-prices[i]);
            sell1=Math.max(sell1,buy1+prices[i]);
            buy2=Math.max(buy2,sell1-prices[i]);
            sell2=Math.max(sell2,buy2+prices[i]);
        }
        
        return sell2;
    }
}
