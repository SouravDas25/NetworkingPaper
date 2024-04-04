package com.github.algo.twopointer;

public class TrappingRainWater {
    public int trap(int[] height) {
        int[] lhmax = new int[height.length];
        int[] rhmax = new int[height.length];
        int j = 0, l = height.length - 1;
        for (int i = 0, k = height.length - 1; i < height.length; i++, k--) {
            lhmax[i] = Math.max(height[i], height[j]);
            rhmax[k] = Math.max(height[k], height[l]);
            if (height[i] > height[j]) {
                j = i;
            }
            if (height[k] > height[l]) {
                l = k;
            }
        }
        int water = 0;
        for (int i = 0; i < height.length; i++) {
            water += Math.min(lhmax[i], rhmax[i]) - height[i];
        }
        return water;
    }
}
