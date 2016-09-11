package com.leetcode;

/**
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * <p>
 * For example:
 * <p>
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 * <p>
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 */
public class Problem258 {
    public static int addDigits(int num) {
        int result = num;
        int temp = 0;
        do {
            do{
                temp = temp + result % 10;
                result = result / 10;
            }while(result!=0);
            result = temp;
            temp=0;
        } while (result / 10 != 0);
        return result;
    }

    public static int addDigits1(int num) {//O(1)
        if(num==0){
            return 0;
        }
        int result = num % 9;
        if(result==0){
            return 9;
        }else{
            return result;
        }
    }

    public static void main(String[] args){
        long startTime = System.nanoTime();   //获取开始时间
        System.out.println(addDigits(123456));
        long endTime = System.nanoTime(); //获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ns");
    }
}
