package com.leetcode.easy;

/**
 * Given a positive integer, return its corresponding column title
 * as appear in an Excel sheet.
 *
 * @see Problem171
 * <p>
 * For example:
 * <p>
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 */
public class Problem168 {

    public static String convertToTitle(int n) {
        if (n <= 26) {
            return String.valueOf((char) (n - 1 + 'A'));
        }
        StringBuilder s = new StringBuilder();
        int r;
        int x = n - 1;
        do {
            r = x % 26;
            x = x / 26 - 1;
            s.insert(0, (char) ('A' + r));
        } while (x >= 0);
        return s.toString();
    }

    public String convertToTitle1(int n) {
        return n == 0 ? "" : convertToTitle1(--n / 26) + (char)('A' + (n % 26));
    }

    public static void main(String args[]) {
        System.out.println(convertToTitle(5));
        System.out.println(convertToTitle(28));
        System.out.println(convertToTitle(100));
    }
}
