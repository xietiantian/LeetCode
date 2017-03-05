package com.leetcode.easy;

/**
 * 26. Remove Duplicates from Sorted Array
 * <p>
 * Given a sorted array, remove the duplicates in place such that each element
 * appear only once and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this in place
 * with constant memory.
 * <p>
 * For example,
 * Given input array nums = [1,1,2],
 * <p>
 * Your function should return length = 2, with the first two elements of nums
 * being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 */
public class Problem026 {
    public int removeDuplicates(int[] nums) {//13ms beats 86.67%
        if (nums == null) {
            return 0;
        }
        if (nums.length < 2) {
            return nums.length;
        }
        int p1 = 0;
        int p2 = 1;
        boolean duplicate = false;
        while (p2 < nums.length) {
            if (nums[p1] != nums[p2]) {
                p1++;
                nums[p1] = nums[p2];
                p2++;
            } else {
                while (p2 < nums.length && nums[p2] == nums[p1]) {
                    p2++;
                }
                p1++;
                if (p2 < nums.length) {
                    nums[p1] = nums[p2];
                    p2++;
                } else {
                    return p1;
                }
            }
        }
        return p1 + 1;
    }

    public int removeDuplicates2(int[] nums) {//13ms beats 86.67%
        int i = nums.length > 0 ? 1 : 0;
        for (int n : nums)
            if (n > nums[i-1])
                nums[i++] = n;
        return i;
    }
}
