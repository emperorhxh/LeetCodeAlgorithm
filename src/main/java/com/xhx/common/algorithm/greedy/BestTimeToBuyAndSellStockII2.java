package com.xhx.common.algorithm.greedy;


//Say you have an array for which the ith element is the price of a given stock on day i.
//Design an algorithm to find the maximum profit. You may complete as many transactions as you 
//like (ie, buy one and sell one share of the stock multiple times). However, you may not engage 
//in multiple transactions at the same time (ie, you must sell the stock before you buy again).

/**
 * 可以买无数次
 */
class BestTimeToBuyAndSellStockII2 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        
        int buy = -prices[0],sell=0;
        for(int i = 1; i < prices.length ; i++) {
            sell=Math.max(sell,buy+prices[i]);
            buy = Math.max(buy,sell-prices[i]);

        }
        
        return sell;
    }
}
