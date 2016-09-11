package com.leetcode;

/**
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * <p>
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function,
 * nums should be [1, 3, 12, 0, 0].
 * <p>
 * Note:
 * <p>
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class Problem283 {
    public static void moveZeroes(int[] nums) {//1ms
        int size = nums.length;
        int zeroCount = 0;
        int i;
        for (i = 0; i < size; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            } else if (zeroCount != 0) {
                nums[i - zeroCount] = nums[i];
            }
        }
        for (i = size - zeroCount; i < size; i++) {
            nums[i] = 0;
        }
    }

    public void moveZeroes1(int[] nums) {//0ms
        if (nums == null || nums.length == 0) {
            return;
        }

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }

        for (int m = j; m < nums.length; m++) {
            nums[m] = 0;
        }

        return;
    }

    public static void main(String args[]) {
        int[] nums = {0, 0, 0};
        moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
