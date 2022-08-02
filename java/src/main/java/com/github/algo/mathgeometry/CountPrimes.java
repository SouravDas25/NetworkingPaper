package com.github.algo.mathgeometry;

import java.util.*;

public class CountPrimes {

    private boolean isPrime(int n) {
        if (n == 0 || n == 1) {
            return false;
        }
        n = Math.abs(n);
        if (n % 2 == 0) {
            return false;
        }
        boolean[] composites = new boolean[n];
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static List<Integer> cache = new ArrayList<>();

    static {
        cache.add(2);
        cache.add(3);
    }

    private int findPrimeCount(int n) {
        int i = Arrays.binarySearch(cache.toArray(Integer[]::new), n);
        if (i < 0) {
            return Math.abs(i) - 1;
        }
        return i;
    }

    public int countPrimes(int n) {
        if (n < cache.get(cache.size() - 1)) {
            return findPrimeCount(n);
        }
        for (int i = cache.get(cache.size() - 1) + 1; i <= n; i++) {
            if (isPrime(i)) {
                cache.add(i);
            }
        }
//        System.out.println(cache);
//        System.out.println(cache.subList(cache.size() -10, cache.size()) + " : " + cache.size());
        return cache.get(cache.size() - 1) < n ? cache.size() : (cache.size() - 1);
    }

}
