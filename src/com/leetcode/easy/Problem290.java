package com.leetcode.easy;

import java.util.HashMap;

/**
 * 290. Word Pattern
 * Given a pattern and a string str, find if str follows the same pattern.
 * <p>
 * Here follow means a full match, such that there is a bijection between
 * a letter in pattern and a non-empty word in str.
 * <p>
 * Examples:
 * <p>
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * pattern = "abba", str = "dog dog dog dog" should return false.
 * <p>
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains
 * lowercase letters separated by a single space.
 */
public class Problem290 {
    public boolean wordPattern(String pattern, String str) {//3ms beats 15.54%
        HashMap<String, Character> wordMap = new HashMap<>();
        char[] patternArray = pattern.toCharArray();
        String[] wordArray = str.split(" ");
        int n = patternArray.length;
        if (wordArray.length != n) {
            return false;
        }
        int i = 0;
        char c;
        while (i < n) {
            if (!wordMap.containsKey(wordArray[i])) {
                if (wordMap.containsValue(patternArray[i])) {
                    return false;
                }
                wordMap.put(wordArray[i], patternArray[i]);
            } else if (wordMap.get(wordArray[i]) != patternArray[i]) {
                return false;
            }
            i++;
        }
        return true;
    }
}
