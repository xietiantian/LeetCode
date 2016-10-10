package com.leetcode.easy;

/**
 * Longest Palindrome
 * Given a string which consists of lowercase or uppercase letters, find the
 * length of the longest palindromes that can be built with those letters.
 * <p>
 * This is case sensitive, for example "Aa" is not considered a palindrome
 * here.
 * <p>
 * Note:
 * Assume the length of given string will not exceed 1,010.
 * <p>
 * Example:
 * <p>
 * Input:
 * "abccccdd"
 * <p>
 * Output:
 * 7
 * <p>
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
public class Problem409 {
    public int longestPalindrome(String s) {//9ms
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] array = s.toCharArray();
        int[] count = new int[52];
        int ret = 0;
        for (char c : array) {
            if (c - 'A' > 25) {
                count[c - 'a' + 26]++;
            } else {
                count[c - 'A']++;
            }
        }
        for (int i : count) {
            if (i > 0) {
                if (i % 2 == 0) {
                    ret += i;
                } else{
                    ret += i - 1;
                }
            }
        }
        if(ret < array.length){
            return ret+1;
        }else{
            return ret;
        }
    }

    public int longestPalindrome1(String s) {//11ms
        int count[] = new int[128];
        int odd = 0, even = 0;
        for(int i = 0; i < s.length(); i++){
            if(++count[s.charAt(i) - 'A'] % 2 == 0){
                even ++; odd --;
            }
            else odd ++;
        }
        return even * 2 + (odd > 0 ? 1 : 0);
    }
}
