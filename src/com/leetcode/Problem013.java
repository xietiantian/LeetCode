package com.leetcode;

/**
 * Roman to Integer
 * <p>
 * Given a roman numeral, convert it to an integer.
 * <p>
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class Problem013 {
    public static int romanToInt(String s) {//7ms
        char[] roman = s.toCharArray();
        int i = 0;
        int result = 0;
        while (i < roman.length) {
            switch (roman[i]) {
                case 'C':
                    i++;
                    if (i >= roman.length) {
                        result += 100;
                        return result;
                    } else if (roman[i] == 'M') {
                        result += 900;
                        i++;
                    } else if (roman[i] == 'D') {
                        result += 400;
                        i++;
                    } else {
                        result += 100;
                    }
                    break;
                case 'X':
                    i++;
                    if (i >= roman.length) {
                        result += 10;
                        return result;
                    } else if (roman[i] == 'C') {
                        result += 90;
                        i++;
                    } else if (roman[i] == 'L') {
                        result += 40;
                        i++;
                    } else {
                        result += 10;
                    }
                    break;
                case 'I':
                    i++;
                    if (i >= roman.length) {
                        result += 1;
                        return result;
                    } else if (roman[i] == 'X') {
                        result += 9;
                        i++;
                    } else if (roman[i] == 'V') {
                        result += 4;
                        i++;
                    } else {
                        result += 1;
                    }
                    break;
                case 'M':
                    i++;
                    result += 1000;
                    break;
                case 'V':
                    i++;
                    result += 5;
                    break;
                case 'L':
                    i++;
                    result += 50;
                    break;
                case 'D':
                    i++;
                    result += 500;
                    break;
                default:
                    return 0;
            }
        }
        return result;
    }

    public int romanToInt1(String s) {//6ms
        int num = 0;
        char last = 0;
        for(int i = 0; i < s.length(); i++){
            final char c = s.charAt(i);
            switch (c){
                case 'I': num ++; break;
                case 'V':
                    num += (last == 'I')?3:5;
                    break;
                case 'X':
                    num += (last == 'I')?8:10;
                    break;
                case 'L':
                    num += (last == 'X')?30:50;
                    break;
                case 'C':
                    num += (last == 'X')?80:100;
                    break;
                case 'D':
                    num += (last == 'C')?300:500;
                    break;
                case 'M':
                    num += (last == 'C')?800:1000;
                    break;
                default: return 0;
            }
            last = c;
        }
        return num;
    }


    public static final int[] sizes = {1, 5, 10, 50, 100, 500, 1000};
    public static final char[] symbols = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    public int romanToInt2(String s) {//7ms
        int i, j, k;

        i = s.length() - 1;
        j = 0;
        k = 0;
        int result = 0;
        while (i >= 0) {
            if (s.charAt(i) == symbols[j]) {
                result += sizes[j];
                i--;
            } else if (j > 0 && s.charAt(i) == symbols[k]) {
                result -= sizes[k];
                i--;
            } else {
                j++;
                k = j % 2 == 0 ? j - 2 : j - 1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(romanToInt("DCXXI"));
    }
}
