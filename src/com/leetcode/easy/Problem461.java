package com.leetcode.easy;

/**
 * The Hamming distance between two integers is the number of positions
 * at which the corresponding bits are different.
 * <p>
 * Given two integers x and y, calculate the Hamming distance.
 * <p>
 * Note:
 * 0 ≤ x, y < 2^31.
 * <p>
 * Example:
 * <p>
 * Input: x = 1, y = 4
 * <p>
 * Output: 2
 * <p>
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * <p>
 * The above arrows point to positions where the corresponding bits are different.
 */
public class Problem461 {
    public int hammingDistance(int x, int y) {//16ms beats 7.18%
        int n = x ^ y;
        int ret = 0;
        while (n != 0) {
            n = n & (n - 1);
            ret++;
        }
        return ret;
    }
}
