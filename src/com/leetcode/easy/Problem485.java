package com.leetcode.easy;

/**
 * 485. Max Consecutive Ones
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 * The maximum number of consecutive 1s is 3.
 * <p>
 * Note:
 * <p>
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 */
public class Problem485 {
    public int findMaxConsecutiveOnes(int[] nums) {//13ms beats 23.70%
        if (nums == null || nums.length == 0) return 0;
        int count = 0;
        int ret = 0;
        for (int n : nums) {
            if (n == 1) {
                count++;
            } else {
                if (count > ret) {
                    ret = count;
                }
                count = 0;
            }
        }
        return ret > count ? ret : count;
        //do not return ret directly, note consecutive ones at the end of nums
    }
}
