package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice
 * in the array, and it should return false if every element is distinct.
 */
public class Problem217 {

    public boolean containsDuplicate(int[] nums) {//11ms
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!hashSet.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate1(int[] nums) {//6ms
        if (nums.length < 2) {
            return false;
        } else {
            int i, j = 0;
            Arrays.sort(nums);
            for (i = 0; i < (nums.length - 1); i++) {
                if (nums[i] == nums[i + 1]) {
                    j = 1;
                    break;
                }
            }
            if (j == 1) {
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * works for both positive and negative numbers.
     * But leetcode gives 'Memory Limit Exceeded'
     * @param nums
     * @return
     */
    public static boolean containsDuplicate2(int[] nums) {//3ms
        int size = Integer.MAX_VALUE;
        byte[] markPOS = new byte[size / 8 + 1];
        byte[] markNEG = new byte[size / 8 + 1];
        boolean flag = false;
        int j = 0, k = 0, check = 0;
        for (int i : nums) {
            if (i > 0) {
                j = i / 8;
                k = i % 8;
                check = 1 << k;
                if ((markPOS[j] & check) != 0) {
                    return true;
                }
                markPOS[j] |= check;
            } else {
                if (i == Integer.MIN_VALUE && !flag) {
                    flag = true;
                } else if (i == Integer.MIN_VALUE) {
                    return true;
                } else {
                    i = Math.abs(i);
                    j = i / 8;
                    k = i % 8;
                    check = 1 << k;
                    if ((markNEG[j] & check) != 0) {
                        return true;
                    }
                    markNEG[j] |= check;
                }
            }
        }
        return false;
    }

}
