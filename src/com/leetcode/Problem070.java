package com.leetcode;

/**
 * Climbing Stairs
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways
 * can you climb to the top?
 */
public class Problem070 {
    //把算过的值存起来，否则计算次数太多会超时
    public static final int[] F = new int[45];//climbStairs(46)会超出Integer.MAX_VALUE
    public static int climbStairs(int n) {
        if(n<=0){
            return 1;
        }
        if(n==1){
            if(F[n]==0){
                F[n]=1;
            }
            return 1;
        }else if(n==2){
            if(F[n]==0){
                F[n]=2;
            }
            return 2;
        }else{
            if(F[n-1]==0){
                F[n-1]=climbStairs(n-1);
            }
            if(F[n-2]==0){
                F[n-2]=climbStairs(n-2);
            }
            return F[n-1]+F[n-2];
        }
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(45));
    }
}
