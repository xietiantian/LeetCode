package com.leetcode.hard;

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

        for (int i = 1; i < days; i++) {
            int diff = prices[i] - prices[i - 1];

            for (int j = 1; j <= k; j++) {
                local[i][j] = Math.max(global[i - 1][j - 1], local[i - 1][j] + diff);
                global[i][j] = Math.max(global[i - 1][j], local[i][j]);
                System.out.print("local&global(" + i + "," + j + "): " + local[i][j] + " " + global[i][j] + "\t");
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


    public static int maxProfit2(int k, int[] prices) {//2ms
        if (k <= 0 || prices == null || prices.length <= 0) return 0;
        if (k > prices.length / 2) { // in this case, it's the same problem as Best Time to Buy & Sell Stock II
            int max = 0;
            for (int i = 0; i < prices.length - 1; i++) {
                int diff = prices[i + 1] - prices[i];
                max += diff > 0 ? diff : 0;
            }
            return max;
        } else {
            int[] buy = new int[k];//buy[j]用来表示第j次买入后的手中的余额
            int[] sell = new int[k];//sell[j]用来表示第j次卖出后的手中的余额

            Arrays.fill(buy, Integer.MIN_VALUE);

            int buffer = 0;// used to avoid duplicate calculation
            int tmp = 0;
            for (int i = 0; i < prices.length; i++) {
                tmp = 0;
                for (int j = 0; j < k; j++) {
                    buffer = tmp - prices[i];//此时tmp是第j次买入前（即第j-1次卖出后）的余额
                    if (buy[j] < buffer)//若第i天进行买入后余额 > i-1天内完成第j次买入后的余额
                        buy[j] = buffer;//则买入，修改buy[j]
                    buffer = buy[j] + prices[i];//计算若以第i天的价格进行第j次卖出后的余额
                    if (sell[j] < buffer)//若第i天进行第j次卖出后的余额 > i-1天进行j次交易后的余额
                        sell[j] = buffer;//则卖出，修改sell[j]
                    tmp = sell[j];
                    System.out.print("buy&sell(" + i + "," + j + "): " + buy[j] + " " + sell[j] + "\t");
                }
                System.out.println();
            }
            return sell[k - 1];
        }
    }

    public static void main(String[] args) {
        int[] p = {7, 2, 5, 6, 6, 4, 2, 8};
        System.out.println(maxProfit(3, p));
        System.out.println(maxProfit2(3, p));
    }
}
