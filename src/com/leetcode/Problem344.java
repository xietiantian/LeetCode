package com.leetcode;

/**
 * Reverse String
 * Write a function that takes a string as input and returns the string reversed.
 * Example:
 * Given s = "hello", return "olleh".
 */
public class Problem344 {

    public static String reverseString(String s) {//by tiantian
        int strLen = s.length();
        if (strLen < 2) {
            return s;
        }
        char[] resultChars = new char[strLen];
        for (int i = 0; i < strLen; i++) {
            resultChars[i] = s.charAt(strLen - i - 1);
        }
//        return new String(resultChars);
        return String.valueOf(resultChars);
    }

    public static String reverseString1(String s) {
        StringBuilder str = new StringBuilder(s);
        return str.reverse().toString();
    }

    public static String reverseString2(String s) {
        int i = 0, j = s.length() - 1;
        char[] str = s.toCharArray();
        while (i < j) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            i++;
            j--;
        }
        String ss = new String(str);
        return ss;
    }

    public static String reverseString3(String s) {
        int head = 0, tail = s.length() - 1;
        char[] ch = new char[s.length()];
        while (head <= tail) {
            ch[head] = s.charAt(tail);
            ch[tail--] = s.charAt(head++);
        }
        return new String(ch);
    }

    /**
     * olleh
     * 程序运行时间： 324702ns
     * olleh
     * 程序运行时间： 60284ns
     * olleh
     * 程序运行时间： 48152ns
     * olleh
     * 程序运行时间： 37987ns
     */
    public static void main(String[] args) {
        // write your code here
        long startTime = System.nanoTime();   //获取开始时间
        System.out.println(reverseString("hello"));
        long endTime = System.nanoTime(); //获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ns");

        startTime = System.nanoTime();   //获取开始时间
        System.out.println(reverseString1("hello"));
        endTime = System.nanoTime(); //获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ns");

        startTime = System.nanoTime();   //获取开始时间
        System.out.println(reverseString2("hello"));
        endTime = System.nanoTime(); //获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ns");

        startTime = System.nanoTime();   //获取开始时间
        System.out.println(reverseString3("hello"));
        endTime = System.nanoTime(); //获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ns");
    }
}
