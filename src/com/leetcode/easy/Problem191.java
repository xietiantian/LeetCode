package com.leetcode.easy;

/**
 * Number of 1 Bits
 * <p>
 * Write a function that takes an unsigned integer and returns the number of
 * ’1' bits it has (also known as the Hamming weight).
 * <p>
 * For example, the 32-bit integer ’11' has binary representation
 * 00000000000000000000000000001011, so the function should return 3.
 */
public class Problem191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int temp = n;
        int count = 0;
        while (temp != 0) {
            temp = temp & (temp - 1);//n=n&(n-1) trick to clear the least significant bit
            count++;
        }
        return count;
    }
}
