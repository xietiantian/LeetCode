package com.leetcode.easy;

/**
 * 88. Merge Sorted Array
 * <p>
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as
 * one sorted array.
 * <p>
 * Note:
 * You may assume that nums1 has enough space (size that is greater or equal to
 * m + n) to hold additional elements from nums2. The number of elements
 * initialized in nums1 and nums2 are m and n respectively.
 */
public class Problem088 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {//1ms beats 6.15%
        if (n <= 0) return;
        if (m <= 0) {
            int i = 0;
            for (int num : nums2) {
                nums1[i] = num;
            }
            return;
        }
        int p = m + n - 1;
        int p1 = m - 1;
        int p2 = n - 1;
        do {
            if (nums1[p1] > nums2[p2]) {
                nums1[p--] = nums1[p1--];
            } else {
                nums1[p--] = nums2[p2--];
            }
        } while (p1 >= 0 && p2 >= 0);
        while (p2 >= 0) {
            nums1[p--] = nums2[p2--];
        }
    }

    public void merge1(int A[], int m, int B[], int n) {//1ms beats 6.15%
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i > -1 && j > -1)
            A[k--] = (A[i] > B[j]) ? A[i--] : B[j--];
        while (j > -1)
            A[k--] = B[j--];
    }
}
