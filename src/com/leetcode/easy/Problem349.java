package com.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * <p>
 * Note:
 * <p>
 * Each element in the result must be unique.
 * The result can be in any order.
 */
public class Problem349 {
    public int[] intersection(int[] nums1, int[] nums2) {//10ms

        Set<Integer> nums1Set = new HashSet<>();
        Set<Integer> nums2Set = new HashSet<>();

        for (int num : nums1) {
            nums1Set.add(num);
        }
        for (int num : nums2) {
            nums2Set.add(num);
        }
        nums2Set.retainAll(nums1Set);
        int[] result = new int[nums2Set.size()];
        int i = 0;
        for (Integer num : nums2Set) {
            result[i++] = num;
        }
        return result;
    }

    public int[] intersection1(int[] nums1, int[] nums2) {//6ms

        HashSet<Integer> set = new HashSet<Integer>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        //Add all elements to set from array 1
        for (int i = 0; i < nums1.length; i++) set.add(nums1[i]);
        for (int j = 0; j < nums2.length; j++) {
            // If present in array 2 then add to res and remove from set
            if (set.contains(nums2[j])) {
                res.add(nums2[j]);
                set.remove(nums2[j]);
            }
        }
        // Convert ArrayList to array
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) arr[i] = res.get(i);
        return arr;
    }


    public int[] intersection2(int[] nums1, int[] nums2) {//120ms
        Set<Integer> set = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        return Arrays.stream(nums1).distinct().filter(e -> set.contains(e)).toArray();
    }
}