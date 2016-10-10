package com.leetcode.easy;

/**
 * Best Time to Buy and Sell Stock II
 * <p>
 * Say you have an array for which the ith element is the price of
 * a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete as
 * many transactions as you like (ie, buy one and sell one share of the
 * stock multiple times). However, you may not engage in multiple
 * transactions at the same time (ie, you must sell the stock before you
 * buy again).
 */
public class Problem122 {
    public int maxProfit(int[] prices) {//1ms
        if (prices.length < 2) {
            return 0;
        }
        int tmp = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > tmp) {
                maxProfit += prices[i] - tmp;
            }
            tmp = prices[i];
        }
        return maxProfit;
    }

    public int maxProfit2(int[] prices) {//另一种答案
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxprofit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;
    }
}
