package com.leetcode;

/**
 * Related to question Excel Sheet Column Title
 *
 * @see Problem168
 * <p>
 * Given a column title as appear in an Excel sheet,
 * return its corresponding column number.
 * <p>
 * For example:
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 */
public class Problem171 {
    public static int titleToNumber(String s) {//3ms
        if (s.isEmpty())
            return 0;
        char[] title = s.toCharArray();
        int result = 0;
        int i = s.length() - 1;
        for (char c : title) {
            result += (c - 'A' + 1) * Math.pow(26, i);
            i--;
        }
        return result;
    }

    public int titleToNumber1(String s) {//2ms
        int answer = 0;
        for(char c: s.toCharArray()) answer = answer * 26 + (c - 'A' + 1);
        return answer;
    }


    public static void main(String args[]) {
        System.out.println(titleToNumber("E"));
        System.out.println(titleToNumber("AB"));
        System.out.println(titleToNumber("CV"));
    }
}
