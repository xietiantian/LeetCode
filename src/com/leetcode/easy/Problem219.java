package com.leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 219. Contains Duplicate II
 * <p>
 * Given an array of integers and an integer k, find out whether there are two
 * distinct indices i and j in the array such that nums[i] = nums[j] and the
 * absolute difference between i and j is at most k.
 */
public class Problem219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {//29ms beats 6.60%
        if (nums.length < 2 || k < 1) {
            return false;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int index;
        for (int i = 0; i < nums.length; i++) {
            index = hashMap.getOrDefault(nums[i], -1);
            if (index < 0 || i - index > k) {
                hashMap.put(nums[i], i);
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate1(int[] nums, int k) {//27ms beats 8.87%
        if (nums.length == 0 || nums == null) return false;
        int n = nums.length;
        k = (k > nums.length) ? nums.length : k;
        HashSet<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (i >= k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }


    public class MyArr {
        int data;
        int index;
    }

    class mycmp implements Comparator<MyArr> {
        @Override
        public int compare(MyArr o1, MyArr o2) {
            return o1.data != o2.data ? o1.data - o2.data : o1.index - o2.index;
        }
    }

    public boolean containsNearbyDuplicate2(int[] nums, int k) {//14ms beats 87.66%
        int len = nums.length;
        MyArr[] myArrs = new MyArr[len];
        for (int i = 0; i < len; ++i) {
            myArrs[i] = new MyArr();
            myArrs[i].data = nums[i];
            myArrs[i].index = i;
        }
        // sort by data first and then index
        Arrays.sort(myArrs, 0, len, new mycmp());
        for (int i = 0; i < len - 1; i++) {
            if (myArrs[i].data == myArrs[i + 1].data
                    && Math.abs((myArrs[i].index - myArrs[i + 1].index)) <= k)
                return true;
        }
        return false;
    }
}
