package com.leetcode;

/**
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 * <p>
 * Example:
 * Given a = 1 and b = 2, return 3.
 */
public class problem371 {
    public static int getSum(int a, int b) {
        int carryBits = (a & b) << 1;
        int sum = a ^ b;
        int temp;
        while (carryBits != 0) {
            temp = sum;
            sum = sum ^ carryBits;
            carryBits = (carryBits & temp) << 1;
        }
        return sum;
    }

    public int getSum1(int a, int b) {
        if(b == 0){//没有进为的时候完成运算
            return a;
        }
        int sum,carry;
        sum = a^b;//完成第一步加发的运算
        carry = (a&b)<<1;//完成第二步进位并且左移运算
        return getSum1(sum,carry);//
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();   //获取开始时间
        System.out.println(getSum(1, 123456));
        long endTime = System.nanoTime(); //获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ns");
    }
}
