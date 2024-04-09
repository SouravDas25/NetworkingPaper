package com.github.algo.binarysearch;

import java.util.Arrays;

public class KokoEatingBananas {

    boolean canComplete(int[] piles, int h, int k) {
        if (k <= 0 || h <= 0) return false;
        int ph = 0;
        for (int pile : piles) {
            int rmdr = pile % k;
            ph += (rmdr == 0) ? pile / k : pile / k + 1;
            if (ph > h) return false;
        }
        return true;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int k = Arrays.stream(piles).max().getAsInt();
        int low = 0, high = k;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canComplete(piles, h, mid)) {
                high = mid - 1;
                k = mid;
            } else {
                low = mid + 1;
            }
        }
        return k;
    }

}
