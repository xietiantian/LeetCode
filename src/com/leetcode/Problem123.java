package com.leetcode;

import sun.security.internal.spec.TlsMasterSecretParameterSpec;

/**
 * Best Time to Buy and Sell Stock III
 * <p>
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete at most two
 * transactions.
 * <p>
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must
 * sell the stock before you buy again).
 */
public class Problem123 {
    public int maxProfit(int[] prices) {//2ms
        if (prices.length < 2) return 0;

        int n = prices.length;
        int[] preProfit = new int[n];
        int[] postProfit = new int[n];

        int curMin = prices[0];
        int tmp;
        for (int i = 1; i < n; i++) {
            if (curMin > prices[i]) {
                curMin = prices[i];
            }
            tmp = prices[i] - curMin;
            if (preProfit[i - 1] < tmp) {
                preProfit[i] = preProfit[i - 1];
            } else {
                preProfit[i] = tmp;

            }
        }

        int curMax = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (curMax < prices[i]) {
                curMax = prices[i];
            }
            tmp = curMax - prices[i];
            if (postProfit[i + 1] > tmp) {
                preProfit[i] = postProfit[i + 1];
            } else {
                preProfit[i] = tmp;

            }
        }

        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            tmp = preProfit[i] + postProfit[i];
            if (maxProfit > tmp) {
                maxProfit = tmp;
            }
        }

        return maxProfit;
    }

    public int maxProfit2(int[] prices) {//4ms
        if (prices.length < 2) return 0;

        int n = prices.length;
        int[] preProfit = new int[n];
        int[] postProfit = new int[n];

        int curMin = prices[0];
        int tmp;
        for (int i = 1; i < n; i++) {
            if (curMin > prices[i]) {
                curMin = prices[i];
            }
            tmp = prices[i] - curMin;
            if (preProfit[i - 1] > tmp) {
                preProfit[i] = preProfit[i - 1];
            } else {
                preProfit[i] = tmp;

            }
        }

        int curMax = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (curMax < prices[i]) {
                curMax = prices[i];
            }
            tmp = curMax - prices[i];
            if (postProfit[i + 1] > tmp) {
                postProfit[i] = postProfit[i + 1];
            } else {
                postProfit[i] = tmp;

            }
        }

        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            tmp = preProfit[i] + postProfit[i];
            if (maxProfit < tmp) {
                maxProfit = tmp;
            }
        }

        return maxProfit;
    }
}
