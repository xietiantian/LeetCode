package com.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Intersection of Two Arrays II
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 * <p>
 * Note:
 * <p>
 * Each element in the result should appear as many times as it shows
 * in both arrays.
 * The result can be in any order.
 * <p>
 * Follow up:
 * <p>
 * What if the given array is already sorted? How would you optimize
 * your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm
 * is better?
 * What if elements of nums2 are stored on disk, and the memory is limited
 * such that you cannot load all elements into the memory at once?
 */
public class Problem350 {
    public static int[] intersect(int[] nums1, int[] nums2) {//5ms
        if(nums1.length==0||nums2.length==0){
            return new int[0];
        }
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int pointer1 = 0;
        int pointer2 = 0;
        while (pointer1 < nums1.length && pointer2 < nums2.length) {
            if (nums1[pointer1] > nums2[pointer2]) {
                pointer2++;
            } else if (nums1[pointer1] < nums2[pointer2]) {
                pointer1++;
            } else {
                result.add(nums1[pointer1]);
                pointer1++;
                pointer2++;
            }
        }
        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) arr[i] = result.get(i);
        return arr;
    }

    public static int[] intersect1(int[] a1, int[] a2) {//3ms
        if (a1.length == 0) return a1; if(a2.length ==0)return a2;
        else{
            Arrays.sort(a1);
            Arrays.sort(a2);

            int maxa1 = a1[a1.length - 1];
            int maxa2 = a2[a2.length - 1];
            int max = Math.max(maxa1, maxa2);

            int j = 0;
            int k = 0;

            int newArray[] = new int [max+1];

            for (int i = 0; i< a2.length; i++)
            {
                newArray[a2[i]] = newArray[a2[i]] + 1;
            }

            int solArray[] = new int [a2.length];
            for(int i = 0; i < a1.length; i++)
            {
                if(newArray[a1[i]] != 0)
                {
                    solArray[j] = a1[i];
                    newArray[a1[i]] = newArray[a1[i]] - 1;
                    j++;
                    k++;
                }
            }

            int[] final1 = Arrays.copyOfRange(solArray, 0, j);
            return final1;
        }
    }


    public static void main(String args[]){
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int [] a = intersect1(nums1,nums2);
        for(int i:a){
            System.out.println(i);
        }
    }
}
