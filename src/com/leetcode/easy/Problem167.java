package com.leetcode.easy;

/**
 * 167. Two Sum II - Input array is sorted
 * <p>
 * Given an array of integers that is already sorted in ascending order,
 * find two numbers such that they add up to a specific target number.
 * <p>
 * The function twoSum should return indices of the two numbers such that
 * they add up to the target, where index1 must be less than index2. Please
 * note that your returned answers (both index1 and index2) are not
 * zero-based.
 * <p>
 * You may assume that each input would have exactly one solution and you
 * may not use the same element twice.
 * <p>
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
public class Problem167 {
    public int[] twoSum(int[] numbers, int target) {
        int index1 = 0;
        int index2 = numbers.length - 1;
        int tmp;
        while (index1 != index2) {
            tmp = numbers[index1] + numbers[index2];
            if (tmp == target) {
                return new int[]{index1 + 1, index2 + 1};
            }
            if (tmp > target) {
                index2--;
            } else {
                index1++;
            }
        }
        return null;
    }
}
