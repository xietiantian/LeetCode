package com.leetcode.easy;

/**
 * 27. Remove Element
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * <p>
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * <p>
 * Example:
 * Given input array nums = [3,2,2,3], val = 3
 * <p>
 * Your function should return length = 2, with the first two elements of nums being 2.
 */
public class Problem027 {
    public static int removeElement(int[] nums, int val) {//9ms beats 73.94%
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                count++;
            } else if (count != 0) {
                nums[i - count] = nums[i];
            }
        }
        return nums.length - count;
    }

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{1}, 1));
    }
}
