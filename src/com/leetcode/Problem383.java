package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given  an  arbitrary  ransom  note  string  and  another  string
 *  containing  letters from  all  the  magazines,  write  a  function
 *  that  will  return  true  if  the  ransom   note  can  be  constructed
 *  from  the  magazines ;  otherwise,  it  will  return  false.
 * <p>
 * Each  letter  in  the  magazine  string  can  only  be  used  once  in  your
 *  ransom  note.
 * <p>
 * Note:
 * You may assume that both strings contain only lowercase letters.
 * <p>
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
public class Problem383 {
    public static boolean canConstruct(String ransomNote, String magazine) {//14ms
        char[] magazineCharArray = magazine.toCharArray();
        int magazineSize = magazine.length();
        char[] ransomCharArray = ransomNote.toCharArray();
        int ransomSize = magazine.length();

        int[] alpha = new int[26];
        for (char x : magazineCharArray) {
            alpha[x - 'a']++;
        }

        for (char x : ransomCharArray) {
            alpha[x - 'a']--;
            if (alpha[x - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }

    public boolean canConstruct1(String ransomNote, String magazine) {//60ms
        Map<Character, Integer> magM = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            int newCount = magM.getOrDefault(c, 0) + 1;
            magM.put(c, newCount);
        }
        for (char c : ransomNote.toCharArray()) {
            int newCount = magM.getOrDefault(c, 0) - 1;
            if (newCount < 0)
                return false;
            magM.put(c, newCount);
        }
        return true;
    }

    public static void main(String args[]) {
        System.out.println(canConstruct("a", "b"));
        System.out.println(canConstruct("aa", "ab"));
        System.out.println(canConstruct("aa", "aab"));

    }
}
