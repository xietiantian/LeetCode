package com.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 483. Find All Anagrams in a String.
 * Given a string s and a non-empty string p, find all the start indices of
 * p's anagrams in s.
 * <p>
 * Strings consists of lowercase English letters only and the length of both
 * strings s and p will not be larger than 20,100.
 * <p>
 * The order of output does not matter.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * Output:
 * [0, 6]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * <p>
 * Example 2:
 * <p>
 * Input:
 * s: "abab" p: "ab"
 * <p>
 * Output:
 * [0, 1, 2]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class Problem483 {
    public static List<Integer> findAnagrams(String s, String p) {//66ms beats 26.55%
        List<Integer> retList = new ArrayList<>();
        HashMap<Character, Integer> pCount = new HashMap<>();
        HashMap<Character, Integer> sCount = new HashMap<>();
        int i, j;
        int pLength = p.length();
        int n = s.length() - p.length() + 1;
        for (i = 0; i < p.length(); i++) {
            pCount.put(p.charAt(i), pCount.getOrDefault(p.charAt(i), 0) + 1);
        }
        i = 0;
        j = 0;
        char[] sCharArray = s.toCharArray();
        while (i < n) {
            while (j < pLength
                    && pCount.getOrDefault(sCharArray[i + j], 0)
                    - sCount.getOrDefault(sCharArray[i + j], 0) > 0) {
                sCount.put(sCharArray[i + j], sCount.getOrDefault(sCharArray[i + j], 0) + 1);
                j++;
            }
            if (j == pLength) {
                retList.add(i);
                sCount.put(sCharArray[i], sCount.get(sCharArray[i]) - 1);
                i++;
                j--;
            } else if (!pCount.containsKey(sCharArray[i + j])) {
                i += j + 1;
                j = 0;
                sCount.clear();
            } else {
                sCount.put(sCharArray[i], sCount.get(sCharArray[i]) - 1);
                i++;
                j--;
            }
        }
        return retList;
    }

    public List<Integer> findAnagrams1(String s, String p) {//39ms beats 33.8%
        List<Integer> ans = new ArrayList<>();
        if (p.length() > s.length()) {
            return ans;
        }
        int[] charCounts = new int[26];
        for (char c : p.toCharArray()) {
            charCounts[toInt(c)]++;
        }

        // Note: in the next iteration of this solution we may be able to move this
        // into the while loop, but this does help my understanding of the solution
        int left = 0;
        int right = 0;
        int numDiff = p.length();
        for (right = 0; right < p.length(); right++) {
            char c = s.charAt(right);
            if (charCounts[toInt(c)] > 0) {
                numDiff--;
            }
            charCounts[toInt(c)]--;
        }
        if (numDiff == 0) {
            ans.add(0);
        }

        // At this point what does the 'charCounts' represent?
        // positive numbers represent the needed number of occurances of a given
        // character that are needed to form an anagram.
        // negative numbers represent number of occurances of a character which is not
        // part of the anagram OR extra occurances of a character which IS part of the anagram.
        // Important note: a charCounts which contains all zero counts represents a state of
        // the anagram's existence.
        while (right < s.length()) {
            char leftChar = s.charAt(left++);
            if (charCounts[toInt(leftChar)] >= 0) {
                // the character we're moving away from is part of the anagram
                // therefore we need to add to the difference
                numDiff++;
            }
            charCounts[toInt(leftChar)]++; // record occurance of character whether of not it's part of the anagram

            char rightChar = s.charAt(right++);
            charCounts[toInt(rightChar)]--;
            // the really interesting part, we end up with negatives in charCounts in two following two cases
            // 1. if the character is not in the anagram
            // 2. if a character IS in the anagram but we don't need any more of it
            if (charCounts[toInt(rightChar)] >= 0) {
                // remember that if by subtracting the count at the right edge the result is 0 or more, it means
                // we have found a character which belongs in the anagram
                numDiff--;
            }

            if (numDiff == 0) {
                ans.add(left);
            }

        }

        return ans;
    }

    private int toInt(char c) {
        return c - 'a';
    }

    public List<Integer> findAnagrams2(String s, String p) { //22ms beats 71.15%
        int[] chars = new int[26];
        List<Integer> result = new ArrayList<>();

        if (s == null || p == null || s.length() < p.length())
            return result;
        for (char c : p.toCharArray())
            chars[c - 'a']++;

        int start = 0, end = 0, count = p.length();
        // Go over the string
        while (end < s.length()) {
            // If the char at start appeared in p, we increase count
            if (end - start == p.length() && chars[s.charAt(start++) - 'a']++ >= 0)
                count++;
            // If the char at end appeared in p (since it's not -1 after decreasing), we decrease count
            if (--chars[s.charAt(end++) - 'a'] >= 0)
                count--;
            if (count == 0)
                result.add(start);
        }

        return result;
    }

    public static void main(String[] args) {
        findAnagrams("abab", "ab");
    }
}
