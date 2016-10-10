package com.leetcode.easy;

/**
 * 405. Convert a Number to Hexadecimal
 * Given an integer, write an algorithm to convert it to hexadecimal.
 * For negative integer, two’s complement method is used.
 * <p>
 * Note:
 * <p>
 * All letters in hexadecimal (a-f) must be in lowercase.
 * The hexadecimal string must not contain extra leading 0s. If the number is
 * zero, it is represented by a single zero character '0'; otherwise, the first
 * character in the hexadecimal string will not be the zero character.
 * The given number is guaranteed to fit within the range of a 32-bit signed
 * integer.
 * You must not use any method provided by the library which converts/formats
 * the number to hex directly.
 * <p>
 * Example 1:
 * Input:
 * 26
 * Output:
 * "1a"
 * <p>
 * Example 2:
 * Input:
 * -1
 * Output:
 * "ffffffff"
 */
public class Problem405 {

    public static String[] hex = {
            "0", "1", "2", "3", "4", "5", "6", "7",
            "8", "9", "a", "b", "c", "d", "e", "f"
    };
    public static String toHex(int num) {//9ms

        if (num == 0) {
            return hex[0];
        }
        int temp;
        StringBuilder ret = new StringBuilder();
        if (num > 0) {
            temp = num;
            do {
                ret.insert(0, hex[temp % 16]);
                temp = temp / 16;
            } while (temp > 0);
        } else {
            temp = num & Integer.MAX_VALUE;
            while (temp > 16) {
                ret.insert(0, hex[temp % 16]);
                temp = temp / 16;
            }
            if (ret.length() == 7) {
                ret.insert(0, hex[temp + 8]);
            } else {
                ret.insert(0, hex[temp]);
                while (ret.length() < 7) {
                    ret.insert(0, '0');
                }
                ret.insert(0, hex[8]);
            }
        }
        return ret.toString();
    }

    public static char[] hexChars = {
        '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
    };
    public static String toHex2(int num) {//7ms
        if (num >= 0 && num < 16)
            return Character.toString(hexChars[num]);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 8 && num != 0; i++) {
            res.insert(0, hexChars[num & 15]);
            num = num >>> 4;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(toHex2(-2147483648));
    }
}
