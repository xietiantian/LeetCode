package com.leetcode.easy;

import java.util.*;

/**
 * 401. Binary Watch
 * <p>
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and
 * the 6 LEDs on the bottom represent the minutes (0-59).
 * <p>
 * Each LED represents a zero or one, with the least significant bit on the
 * right.
 * https://upload.wikimedia.org/wikipedia/commons/8/8b/Binary_clock_samui_moon.jpg
 * For example, the above binary watch reads "3:25".
 * <p>
 * Given a non-negative integer n which represents the number of LEDs that are
 * currently on, return all possible times the watch could represent.
 * <p>
 * Example:
 * Input: n = 1
 * Return: ["1:00", "2:00", "4:00", "8:00", "0:01",
 * "0:02", "0:04", "0:08", "0:16", "0:32"]
 * <p>
 * Note:
 * - The order of output does not matter.
 * - The hour must not contain a leading zero, for example "01:00" is not valid,
 * it should be "1:00".
 * - The minute must be consist of two digits and may contain a leading zero,
 * for example "10:2" is not valid, it should be "10:02".
 */
public class Problem401 {
    public List<String> ret = new LinkedList<>();
    public int intSolution = 0;
    public String strSolution;

    public List<String> readBinaryWatch(int num) {// 回溯 20ms
        if (num < 0 || num > 8) {
            return ret;
        }

        if (num == 0) {
            ret.add("0:00");
            return ret;
        }

        backtrack(0, 0, num);
        return ret;
    }

    void backtrack(int dimension, int weight, int num) {
        intSolution = intSolution & (0x3FF >> (10 - dimension));
        if (weight == num) {
            //check & record
            strSolution = toString(intSolution);
            if (strSolution != null) {
                System.out.println(strSolution);
                ret.add(strSolution);
            }
            return;
        }

        if (10 - dimension + weight < num) {
            return;
        }

        //current dimension x = 0
        backtrack(dimension + 1, weight, num);

        //current dimension x = 1
        intSolution = intSolution | (1 << dimension);
        backtrack(dimension + 1, weight + 1, num);
    }

    String toString(int n) {
        int min = n & 0x3F;
        int hour = (n >> 6) & 0x0F;
        if (min < 60 && hour < 12) {
            if (min < 10) {
                return Integer.toString(hour) + ":0" + Integer.toString(min);
            } else {
                return Integer.toString(hour) + ":" + Integer.toString(min);
            }
        } else {
            return null;
        }
    }


    public List<String> readBinaryWatch1(int num) {//排列组合？4ms
        List<String> res = new ArrayList<>();
        int[] nums1 = new int[]{8, 4, 2, 1};
        int[] nums2 = new int[]{32, 16, 8, 4, 2, 1};
        for (int i = 0; i <= num; i++) {
            List<Integer> list1 = generateDigit(nums1, i);
            List<Integer> list2 = generateDigit(nums2, num - i);
            for (int num1 : list1) {
                if (num1 >= 12) continue;
                for (int num2 : list2) {
                    if (num2 >= 60) continue;
                    res.add(num1 + ":" + (num2 < 10 ? "0" + num2 : num2));
                }
            }
        }
        return res;
    }

    /**
     *
     * @param nums
     * @param count 1的个数（即list中的整数有nums中几个数的和组成）
     * @return 返回整型list
     */
    private List<Integer> generateDigit(int[] nums, int count) {
        List<Integer> res = new ArrayList<>();
        generateDigitHelper(nums, count, 0, 0, res);
        return res;
    }

    private void generateDigitHelper(int[] nums, int count, int pos, int sum, List<Integer> res) {
        if (count == 0) {
            res.add(sum);
            return;
        }

        for (int i = pos; i < nums.length; i++) {
            generateDigitHelper(nums, count - 1, i + 1, sum + nums[i], res);
        }
    }


    // beats 93%, not bad
    public List<String> readBinaryWatch2(int num) {//回溯法 2ms
        // little trick here is to compute a mask array beforehand for latter use.
        int[] bitMask = new int[10];
        int mask = 1;
        for (int i = 0; i < 10; i ++) {
            bitMask[i] = mask << i;
        }
        List<String> result = new ArrayList<>();
        // The rest part is the standard backtracking flow
        backtracking(num, bitMask, 0, 0, 0, result);
        return result;
    }

    public void backtracking(int num, int[] bitMask, int cnt, int startPos, int currVal, List<String> result) {
        // We check the result only when the count of bits set to 1 is equal to num
        if (cnt == num) {
            int minute = currVal % 64;
            int hour = currVal >> 6;
            if (minute < 60 && hour < 12) {
                StringBuilder sb = new StringBuilder();
                sb.append(hour).append(':');
                if (minute < 10) {
                    sb.append(0);
                }
                sb.append(minute);
                result.add(sb.toString());
            }
        } else {
            for (int i = startPos; i <= 10 - num + cnt; i ++) {
                backtracking(num, bitMask, cnt + 1, i + 1, currVal | bitMask[i], result);
            }
        }
    }


    // beats 92% not bad either.
    public List<String> readBinaryWatch3(int num) {//bit_manipulation 3ms
        List<String> result = new ArrayList<>();
        int start = (1 << num) - 1;
        int end = (1 << 10) - 1;
        int mask = (1 << (10 - num)) - 1;
        end ^= mask;
        for (int i = start; i <= end; i ++) {
            if (Integer.bitCount(i) == num) {
                int minute = i % 64;
                int hour = i >> 6;
                if (minute >= 60 || hour >= 12) {
                    continue;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(hour).append(':');
                if (minute < 10) {
                    sb.append(0);
                }
                sb.append(minute);
                result.add(sb.toString());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Problem401 p = new Problem401();
        p.readBinaryWatch(2);
        for (String str : p.ret) {
            System.out.println(str);
        }
    }
}
