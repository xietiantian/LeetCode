package com.leetcode.easy;

/**
 * 204. Count Primes
 * <p>
 * Count the number of prime numbers less than a non-negative number, n.
 */
public class Problem204 {
    public int countPrimes(int n) {//23ms beats 92.51%
        if (n < 3) {
            return 0;
        }
        boolean[] notPrime = new boolean[n];
        int count = 0;
        int limit = (int) Math.sqrt(n - 1);
        int i, j;
        for (i = 2; i <= limit; i++) {
            if (!notPrime[i]) {
                count++;
                for (j = i * i; j < n; j += i)
                    notPrime[j] = true;
            }
        }
        for (; i < n; i++) {
            if (!notPrime[i]) {
                count++;
            }
        }
        return count;
    }
}
