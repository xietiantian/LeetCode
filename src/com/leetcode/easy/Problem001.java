package com.leetcode.easy;

import java.util.HashMap;

/**
 * 1. Two Sum
 * <p>
 * Given an array of integers, return indices of the two numbers such that
 * they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you
 * may not use the same element twice.
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class Problem001 {

    public int[] twoSum(int[] nums, int target) { // 1 ms, faster than 99.98%
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            Integer sumWith = hashMap.get(nums[i]);
            if (sumWith != null) {
                return new int[]{sumWith, i};
            } else {
                hashMap.put(target - nums[i], i);
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] array = twoSum(new int[]{3, 3}, 6);
        for(int e:array){
            System.out.println(e);
        }
    }
}
