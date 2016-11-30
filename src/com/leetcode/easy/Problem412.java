package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Fizz Buzz
 * <p>
 * Write a program that outputs the string representation of numbers from 1 to n.
 * <p>
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
 * <p>
 * Example:
 * <p>
 * n = 15,
 * <p>
 * Return:
 * [
 * "1",
 * "2",
 * "Fizz",
 * "4",
 * "Buzz",
 * "Fizz",
 * "7",
 * "8",
 * "Fizz",
 * "Buzz",
 * "11",
 * "Fizz",
 * "13",
 * "14",
 * "FizzBuzz"
 * ]
 */
public class Problem412 {
    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";

    public static List<String> fizzBuzz(int n) {
        ArrayList<String> ret = new ArrayList<>();
        if (n == 0) {
            return ret;
        }

        for (int i = 1; i <= n; i++) {
            if (i % 3 != 0 && i % 5 != 0) {
                ret.add(Integer.toString(i));
            } else {
                if (i % 15 == 0) {
                    ret.add(FIZZ + BUZZ);
                } else if (i % 3 == 0) {
                    ret.add(FIZZ);
                }else{
                    ret.add(BUZZ);
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        List<String> list = fizzBuzz(15);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
