package com.leetcode.easy;

/**
 * 345. Reverse Vowels of a String
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * <p>
 * Example 1:
 * Given s = "hello", return "holle".
 * <p>
 * Example 2:
 * Given s = "leetcode", return "leotcede".
 * <p>
 * Note:
 * The vowels does not include the letter "y".
 */
public class Problem345 {

    public String reverseVowels(String s) {//5ms beats 86.95%
        char[] charArray = s.toCharArray();
        int p1 = 0;
        int p2 = charArray.length - 1;
        char tmp;

        while (p1 < p2) {
            while (p1 < p2 && !isVowel(charArray[p1])) {
                p1++;
            }
            while (p1 < p2 && !isVowel(charArray[p2])) {
                p2--;
            }
            if (p1 < p2) {
                tmp = charArray[p1];
                charArray[p1] = charArray[p2];
                charArray[p2] = tmp;
                p1++;
                p2--;
            }
        }

        return new String(charArray);
    }

    private boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {//别忘了大写
            return true;
        } else {
            return false;
        }
    }
}
