package com.github.algo.twopointer;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int maxArea = 0;
        while (i < j) {
            int h = Math.min(height[i], height[j]);
            int area = h * (j - i);
            maxArea = Math.max(maxArea, area);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }
}
