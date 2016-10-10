package com.leetcode.easy;

/**
 * Power of Three
 * <p>
 * Given an integer, write a function to determine if it is a power of three.
 * <p>
 * Follow up:
 * Could you do it without using any loop / recursion?
 */
public class Problem326 {
    public boolean isPowerOfThree(int n) {//19ms
        // 1162261467 is 3^19,  3^20 is bigger than int
        return ( n>0 &&  1162261467%n==0);
    }

    public boolean isPowerOfThree1(int n) {//19ms
        return n == 1 || !(n == 0 || n % 3 != 0) && isPowerOfThree(n / 3);
    }
}
