package com.leetcode.easy;

/**
 * Created by tiantian on 16-11-30.
 * Minimum Moves to Equal Array Elements
 * <p>
 * Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.
 * <p>
 * Example:
 * <p>
 * Input:
 * [1,2,3]
 * <p>
 * Output:
 * 3
 * <p>
 * Explanation:
 * Only three moves are needed (remember each move increments two elements):
 * <p>
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 */
public class Problem453 {
    public int minMoves(int[] nums) {//10ms beat90%
        int min = nums[0];
        int ret = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                ret += i * (min - nums[i]);
                min = nums[i];
            } else {
                ret += nums[i] - min;
            }
        }
        return ret;
    }
}
