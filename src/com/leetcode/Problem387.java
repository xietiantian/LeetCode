package com.leetcode;

import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.util.*;

/**
 * Given a string, find the first non-repeating character in it and return it's
 * index. If it doesn't exist, return -1.
 * <p>
 * Examples:
 * <p>
 * s = "leetcode"
 * return 0.
 * <p>
 * s = "loveleetcode",
 * return 2.
 * <p>
 * Note: You may assume the string contain only lowercase letters.
 */
public class Problem387 {
    public int firstUniqChar(String s) {
        if (s == null || s.equals("")) return -1;
        char[] c = s.toCharArray();
        int[] cnt = new int[256];

        for (int i = 0; i < c.length; i++) {
            cnt[c[i]]++;
        }

        for (int i = 0; i < c.length; i++) {
            if (cnt[c[i]] == 1) return i;
        }
        return -1;
    }
}
