package com.leetcode.easy;

import java.util.HashMap;

/**
 * 205. Isomorphic Strings
 * Given two strings s and t, determine if they are isomorphic.
 * <p>
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * <p>
 * All occurrences of a character must be replaced with another character
 * while preserving the order of characters. No two characters may map to
 * the same character but a character may map to itself.
 * <p>
 * For example,
 * Given "egg", "add", return true.
 * <p>
 * Given "foo", "bar", return false.
 * <p>
 * Given "paper", "title", return true.
 * <p>
 * Note:
 * You may assume both s and t have the same length.
 */
public class Problem205 {
    public boolean isIsomorphic(String s, String t) {//15 ms beats 67.04%
        HashMap<Character, Character> wordMap = new HashMap<>();
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        int n = sArray.length;
        if (tArray.length != n) {
            return false;
        }
        int i = 0;
        while (i < n) {
            if (!wordMap.containsKey(tArray[i])) {
                if (wordMap.containsValue(sArray[i])) {
                    return false;
                }
                wordMap.put(tArray[i], sArray[i]);
            } else if (wordMap.get(tArray[i]) != sArray[i]) {
                return false;
            }
            i++;
        }
        return true;
    }

    public boolean isIsomorphic1(String s, String t) {//3ms beats 99.25%
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        int length = sArray.length;
        if(length != tArray.length) return false;

        char[] sm = new char[256];
        char[] tm = new char[256];

        for(int i=0; i<length; i++){
            char sc = sArray[i];
            char tc = tArray[i];
            if(sm[sc] == 0 && tm[tc] == 0){
                sm[sc] = tc;
                tm[tc] = sc;
            }else{
                if(sm[sc] != tc || tm[tc] != sc){
                    return false;
                }
            }
        }
        return true;
    }
}
