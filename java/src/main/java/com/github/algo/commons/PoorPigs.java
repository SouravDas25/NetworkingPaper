package com.github.algo.commons;

public class PoorPigs {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int test = minutesToTest / minutesToDie + 1;
        int n = test;
        int count = 1;
        while (n < buckets) {
            n *= test;
            count++;
        }
        return count;
    }

}
