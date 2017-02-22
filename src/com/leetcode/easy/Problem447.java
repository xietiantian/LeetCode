package com.leetcode.easy;

import com.sun.deploy.security.SecureStaticVersioning;

import java.util.HashMap;
import java.util.Map;

/**
 * 447. Number of Boomerangs
 * Given n points in the plane that are all pairwise distinct, a "boomerang"
 * is a tuple of points (i, j, k) such that the distance between i and j equals
 * the distance between i and k (the order of the tuple matters).
 * <p>
 * Find the number of boomerangs. You may assume that n will be at most 500
 * and coordinates of points are all in the range [-10000, 10000] (inclusive).
 * <p>
 * Example:
 * <p>
 * Input:
 * [[0,0],[1,0],[2,0]]
 * <p>
 * Output:
 * 2
 * <p>
 * Explanation:
 * The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 */
public class Problem447 {
    //beat 96.8% 147 ms
    public static int numberOfBoomerangs(int[][] points) {
        int n = points.length;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>(points.length);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];
                int d = dx * dx + dy * dy;
                Integer value = map.get(d);
                if (value != null) {
                    count += 2 * value;
                    map.put(d, value + 1);
                } else {
                    map.put(d, 1);
                }
            }
            map.clear();
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {2, 0}}));
    }
}
