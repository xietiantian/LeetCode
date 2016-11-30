package com.leetcode.easy;

import java.util.*;

/**
 * Valid Anagram
 * Given two strings s and t, write a function to determine if t is
 * an anagram of s.
 * <p>
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * <p>
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * <p>
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your
 * intSolution to such case?
 */
public class Problem242 {

    public static boolean isAnagram(String s, String t) {//36ms
        Map<Character, Integer> magM = new HashMap<>();
        for (char c : s.toCharArray()) {
            int newCount = magM.getOrDefault(c, 0) + 1;
            magM.put(c, newCount);
        }
        for (char c : t.toCharArray()) {
            int newCount = magM.getOrDefault(c, 0) - 1;
            if (newCount < 0)
                return false;
            magM.put(c, newCount);
        }
        HashSet<Integer> valueExcpZero = new HashSet<>(magM.values());
        valueExcpZero.remove(0);
        return valueExcpZero.isEmpty();
    }

    public static boolean isAnagram1(String s, String t) {//8ms
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    public static void main(String args[]){
        System.out.println(isAnagram("中文", "zhong"));
        System.out.println(isAnagram1("中文哈哈哈", "中哈哈文哈"));

    }
}
