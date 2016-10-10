package com.leetcode.easy;

import com.sun.xml.internal.ws.api.message.Packet;

import java.util.HashSet;

/**
 * Happy Number
 * <p>
 * Write an algorithm to determine if a number is "happy".
 * <p>
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 * <p>
 * Example: 19 is a happy number
 * <p>
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */
public class Problem202 {
    public static boolean isHappy(int n) {//7ms
        HashSet<Integer> hashSet = new HashSet<>();
        int cur = n;
        int temp = 0;
        while (hashSet.add(cur)) {
            while (cur != 0) {
                // 改为这句时间缩短到5ms
                // temp += (cur % 10)*(cur %10);
                temp += Math.pow(cur % 10, 2);
                cur = cur / 10;
            }
            cur = temp;
            temp = 0;
        }
        if (cur == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
}
