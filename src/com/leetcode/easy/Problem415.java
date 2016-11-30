package com.leetcode.easy;

/**
 * Add Strings
 * <p>
 * Given two non-negative numbers num1 and num2 represented as string, return the sum of num1 and num2.
 * <p>
 * Note:
 * <p>
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class Problem415 {
    public static String addStrings(String num1, String num2) {//28ms
//        // suppose num1 is shorter
//        if(num1.length()>num2.length()) return addStrings(num2, num1);

        char[] longNum, shortNum;
        if (num1.length() <= num2.length()) {
            shortNum = num1.toCharArray();
            longNum = num2.toCharArray();
        } else {
            shortNum = num2.toCharArray();
            longNum = num1.toCharArray();
        }

        StringBuilder sum = new StringBuilder();

        int i = shortNum.length - 1;
        int j = longNum.length - 1;
        int c = 0;
        int digitSum;
        while (i >= 0) {
            digitSum = c + shortNum[i] + longNum[j] - 96;
            if (digitSum > 9) {
                digitSum = digitSum - 10;
                c = 1;
            } else {
                c = 0;
            }
            sum.insert(0, digitSum);
            i--;
            j--;
        }
        i = longNum.length - shortNum.length - 1;
        while (i >= 0) {
            digitSum = c + longNum[i] - 48;
            if (digitSum > 9) {
                digitSum = digitSum - 10;
                c = 1;
            } else {
                c = 0;
            }
            sum.insert(0, digitSum);
            i--;
        }
        if (c > 0) {
            sum.insert(0, c);
        }
        return sum.toString();
    }

    public static String addStrings1(String num1, String num2) {//22ms beat93%
        // suppose num1 is shorter
        if (num1.length() > num2.length())
            return addStrings1(num2, num1);
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();
        int len1 = arr1.length;
        int len2 = arr2.length;
        int carry = 0;
        for (int i = 0; i < len2; ++i) {
            int idx1 = len1 - i - 1, idx2 = len2 - i - 1;

            if (idx1 >= 0) arr2[idx2] += (arr1[idx1] - '0' + carry);
            else if (carry == 0) break;
            else arr2[idx2] += carry;

            if (arr2[idx2] > '9') {
                carry = 1;
                arr2[idx2] -= 10;
            } else carry = 0;
        }
        return carry == 1 ? "1".concat(String.valueOf(arr2)) : String.valueOf(arr2);
    }

    public static void main(String[] args) {
        System.out.println(addStrings1("1", "9"));
    }
}
