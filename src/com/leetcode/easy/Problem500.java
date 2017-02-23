package com.leetcode.easy;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;

/**
 * 500. Keyboard Row
 * Given a List of words, return the words that can be typed using letters of
 * ALPHABET on only one row's of American keyboard like the image below.
 * Example 1:
 * <p>
 * Input: ["Hello", "Alaska", "Dad", "Peace"]
 * Output: ["Alaska", "Dad"]
 * <p>
 * Note:
 * <p>
 * You may use one character in the keyboard more than once.
 * You may assume the input string will only contain letters of ALPHABET.
 */
public class Problem500 {
    public static final int[] ALPHABET = new int[]{1, 2, 2, 1, 0, 1, 1, 1, 0, 1,
            1, 1, 2, 2, 0, 0, 0, 0, 1, 0, 0, 2, 0, 2, 0, 2};

    public static String[] findWords(String[] words) {//3ms beats 81.85%
        ArrayList<String> retWords = new ArrayList<>();
        int i, l, flag;
        char c;
        for (String word : words) {
            l = word.length();
            c = word.charAt(0);
            flag = ALPHABET[c < 'a' ? c - 'A' : c - 'a'];
            i = 1;
            for(i=1;i<l;i++){
                c = word.charAt(i);
                if(flag != ALPHABET[c < 'a' ? c - 'A' : c - 'a']){
                    break;
                }
            }
            if (i == l) {
                retWords.add(word);
            }
        }
        String[] ret = new String[retWords.size()];
        retWords.toArray(ret);
        return ret;
    }

    public static void main(String[] args) {
        String[] words = findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"});
        for (String word : words) {
            System.out.println(word);
        }
    }
}
