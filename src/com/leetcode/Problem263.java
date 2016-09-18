package com.leetcode;

/**
 * Ugly Number
 * <p>
 * Write a program to check whether a given number is an ugly number.
 * <p>
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * For example,
 * 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
 * <p>
 * Note that 1 is typically treated as an ugly number.
 */
public class Problem263 {
    public boolean isUgly(int num) {//2ms
        if(num <= 0){
            return false;
        }

        while(num % 2 == 0){
            num = num / 2;
        }

        while(num % 3 == 0){
            num = num / 3;
        }

        while(num % 5 == 0){
            num = num / 5;
        }
        return num == 1;
    }
}
