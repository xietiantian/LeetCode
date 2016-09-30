package com.leetcode;

import java.util.Arrays;

/**
 * Best Time to Buy and Sell Stock IV
 * <p>
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 * <p>
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class Problem188 {
    public static int maxProfit(int k, int[] prices) {//8ms
        if (prices.length < 2) return 0;

        int days = prices.length;
        if (k >= days) return maxProfitII(prices);

        int[][] local = new int[days][k + 1];
        int[][] global = new int[days][k + 1];

        for (int i = 1; i < days ; i++) {
            int diff = prices[i] - prices[i - 1];

            for (int j = 1; j <= k; j++) {
                local[i][j] = Math.max(global[i - 1][j - 1], local[i - 1][j] + diff);
                global[i][j] = Math.max(global[i - 1][j], local[i][j]);
                System.out.print("("+i+", "+j+") : ("+local[i][j]+", "+global[i][j]+")    ");
            }
            System.out.println();
        }

        return global[days - 1][k];
    }

    public static int maxProfitII(int[] prices) {
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }

        return maxProfit;
    }


    public int maxProfit2(int k, int[] prices) {//2ms
        if (k <= 0 || prices == null || prices.length <= 0) return 0;
        if (k > prices.length / 2) { // in this case, it's the same problem as Best Time to Buy & Sell Stock II
            int max = 0;
            for (int i = 0; i < prices.length - 1; i++) {
                int diff = prices[i + 1] - prices[i];
                max += diff>0 ? diff : 0;
            }
            return max;
        } else {
            int [] buy = new int[k];
            int [] sell = new int[k];

            Arrays.fill(buy, Integer.MIN_VALUE);

            for (int price: prices) {
                int tmp = 0;
                for (int i = 0; i < k; i ++) {
                    int buffer = 0;                          // used to avoid duplicate calculation
                    buffer = tmp - price;
                    if (buy[i] < buffer) buy[i] = buffer;

                    buffer = buy[i] + price;
                    if (sell[i] < buffer) sell[i] = buffer;
                    tmp = sell[i];
                }
            }

            return sell[k - 1];
        }

    }

    public static void main(String[] args) {
        int [] p = {7, 2, 5, 6, 6, 4, 2, 8};
        System.out.println(maxProfit(3, p));
    }
}
