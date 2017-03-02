package com.leetcode.easy;

import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * 414. Third Maximum Number
 * <p>
 * Given a non-empty array of integers, return the third maximum number in
 * this array. If it does not exist, return the maximum number. The time
 * complexity must be in O(n).
 * <p>
 * Example 1:
 * <p>
 * Input: [3, 2, 1]
 * <p>
 * Output: 1
 * <p>
 * Explanation: The third maximum is 1.
 * <p>
 * Example 2:
 * <p>
 * Input: [1, 2]
 * <p>
 * Output: 2
 * <p>
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 * <p>
 * Example 3:
 * <p>
 * Input: [2, 2, 3, 1]
 * <p>
 * Output: 1
 * <p>
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 */
public class Problem414 {
    public static int thirdMax(int[] nums) {//10ms beats 50.49%
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for (Integer n : nums) {
            if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;
            if (max1 == null || n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (max2 == null || n > max2) {
                max3 = max2;
                max2 = n;
            } else if (max3 == null || n > max3) {
                max3 = n;
            }
        }
        return max3 == null ? max1 : max3;
    }

    public int thirdMax1(int[] nums) {//18ms 19.99%
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i : nums) {
            if (!pq.contains(i)) {
                pq.add(i);
            }
            if (pq.size() > 3) {
                pq.poll();
            }
        }
        if (pq.size() == 2) {
            pq.poll();
        }
        return pq.poll();
    }

    public final int N = 3;
    public int thirdMax2(int[] nums) {//16ms 25.15%
        if (nums.length == 0) return 0;

        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) continue;
            if (set.size() < N || nums[i] > set.first()) {
                if (set.size() == N) set.remove(set.first());
                set.add(nums[i]);
            }
        }
        return set.size() == N ? set.first() : set.last();
    }

    public static void main(String[] args) {
        System.out.println(thirdMax(new int[]{2, 2, 3, 1}));
    }
}
