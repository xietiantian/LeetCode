package com.leetcode;

/**
 * Best Time to Buy and Sell Stock
 * Say you have an array for which the ith element is the price of
 * a given stock on day i.
 * <p>
 * If you were only permitted to complete at most one transaction
 * (ie, buy one and sell one share of the stock), design an algorithm
 * to find the maximum profit.
 * <p>
 * Example 1:
 * Input: [7, 1, 5, 3, 6, 4]
 * Output: 5
 * max. difference = 6-1 = 5
 * (not 7-1 = 6, as selling price needs to be larger than buying price)
 * <p>
 * Example 2:
 * Input: [7, 6, 4, 3, 1]
 * Output: 0
 * In this case, no transaction is done, i.e. max profit = 0.
 */
public class Problem121 {
    public int maxProfit(int[] prices) {//1ms
        if(prices.length<2){
            return 0;
        }
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice)
                minPrice = prices[i];
            else if (prices[i] - minPrice > maxProfit)
                maxProfit = prices[i] - minPrice;
        }
        return maxProfit;
    }
}
