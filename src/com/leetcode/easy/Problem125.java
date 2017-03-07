package com.leetcode.easy;

/**
 * 125. Valid Palindrome
 * <p>
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * <p>
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * <p>
 * Note:
 * Have you consider that the string might be empty? This is a good
 * question to ask during an interview.
 * <p>
 * For the purpose of this problem, we define empty string as valid
 * palindrome.
 */
public class Problem125 {
    public boolean isPalindrome(String s) {//6ms  beats 94.51%
        char[] charArray = s.toCharArray();
        int p1 = 0;
        int p2 = charArray.length - 1;
        while (p1 < p2) {
            while (p1 < p2 && !inAlphabet(charArray[p1])) {
                p1++;
            }
            while (p1 < p2 && !inAlphabet(charArray[p2])) {
                p2--;
            }
            if (p1 == p2) {
                return true;
            }
            if (p1 > p2
                    || Character.toLowerCase(charArray[p1++])
                    != Character.toLowerCase(charArray[p2--])) {
                return false;
            }
        }
        return true;
    }

    private boolean inAlphabet(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
            return true;
        }
        return false;
    }

}
