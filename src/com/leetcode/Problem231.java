package com.leetcode;

/**
 * Given an integer, write a function to determine if it is a power of two.
 */
public class Problem231 {
    public boolean isPowerOfTwo(int n) {//2ms
        return (n > 0 && (n & (n - 1)) == 0);
    }
}
