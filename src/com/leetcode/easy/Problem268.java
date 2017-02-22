package com.leetcode.easy;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
 * find the one that is missing from the array.
 * <p>
 * For example,
 * Given nums = [0, 1, 3] return 2.
 * <p>
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement
 * it using only constant extra space complexity?
 */
public class Problem268 {
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int ret = 0;
        for (int i = 0; i < n; i++) {
            ret ^= nums[i] ^ i;
        }
        return ret ^ n;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{1, 0, 3}));
    }
}
