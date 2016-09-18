package com.leetcode;

/**
 * Power of Four
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 * <p>
 * Example:
 * Given num = 16, return true. Given num = 5, return false.
 * <p>
 * Follow up: Could you solve it without loops/recursion?
 */
public class Problem342 {
    public static boolean isPowerofFour(int num) {//2ms
        if (num <= 0) {
            return false;
        }
        double sqr = Math.sqrt(num);
        int sqrInt = (int) sqr;
        if (sqr == sqrInt && (sqrInt & (sqrInt - 1) )== 0) {
            return true;
        }else{
            return false;
        }
    }

    public boolean isPowerOfFour1(int num) {//29ms
        return Integer.toBinaryString(num).matches("1(00)*");
    }

    public static void main(String[] args){
        System.out.println(isPowerofFour(1));
    }
}
