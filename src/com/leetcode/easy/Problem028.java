package com.leetcode.easy;

/**
 * Implement strStr().
 * <p>
 * Returns the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 * <p>
 * KMP算法参考
 * http://blog.csdn.net/fightlei/article/details/52712461
 */
public class Problem028 {
    public static int strStr(String haystack, String needle) {//O(m*n) BF算法 超时
        if (needle.length() == 0) {
            return 0;
        }
        int p1 = 0;
        int p2 = 0;
        while (p1 < haystack.length()) {
            while (p1 < haystack.length() && haystack.charAt(p1) != needle.charAt(p2)) {
                p1++;
            }
            while (p1 < haystack.length() && p2 < needle.length() && haystack.charAt(p1) == needle.charAt(p2)) {
                p1++;
                p2++;
            }
            if (p2 == needle.length()) {
                return p1 - p2;
            }
            p1 -= p2 - 1;
            p2 = 0;
        }
        return -1;
    }

    public int strStr1(String haystack, String needle) {//BF 15ms beats 18.53%
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }

    public static int strStr2(String haystack, String needle) {//O(m+n) KMP算法 21ms beats 5.54%
        if (needle.length() == 0) {
            return 0;
        }
        int i = 0;
        int j = 0;
        //得到next数组
        int[] next = getNext(needle);
        while (i < haystack.length() && j < needle.length()) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                //根据next数组的指示j进行回溯，而i永远不会回溯
                j = next[j];
            }
        }
        if (j == needle.length()) {
            return i - j;
        } else {
            return -1;
        }
    }

    public static int[] getNext0(String t) {
        int[] next = new int[t.length()];
        next[0] = -1;
        int suffix = 0;  // 后缀
        int prefix = -1;  // 前缀
        while (suffix < t.length() - 1) {
            //若前缀索引为-1或相等，则前缀后缀索引均+1
            if (prefix == -1 || t.charAt(prefix) == t.charAt(suffix)) {
                ++prefix;
                ++suffix;
                // prefix表示对于子串T[0]~T[suffix-1]前面有prefix个字符与
                // 后面prefix个字符相等，就是next[suffix]
                next[suffix] = prefix;
            } else {
                prefix = next[prefix];  //2
            }
        }
        return next;
    }

    public static int[] getNext(String t) {//比getNext0更好
        int[] next = new int[t.length()];
        next[0] = -1;
        int suffix = 0;  // 后缀
        int prefix = -1;  // 前缀
        while (suffix < t.length() - 1) {
            //若相等或前缀索引为-1，则前缀后缀索引均+1
            if (prefix == -1 || t.charAt(prefix) == t.charAt(suffix)) {
                ++prefix;
                ++suffix;
                //改进的地方
                if (t.charAt(prefix) == t.charAt(suffix)) {
                    next[suffix] = next[prefix];
                } else {
                    next[suffix] = prefix;
                }
            } else {
                prefix = next[prefix];
            }
        }
        for (int n : next) {
            System.out.print(n + " ");
        }
        return next;
    }
}
