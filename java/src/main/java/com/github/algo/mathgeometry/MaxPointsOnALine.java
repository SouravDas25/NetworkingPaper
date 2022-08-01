package com.github.algo.mathgeometry;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {

    private double getSlope(int[] a, int[] b) {
        if (b[1] == a[1]) return Double.MAX_VALUE;
        if (b[0] == a[0]) return 0;
        return (b[1] - a[1]) / (double)(b[0] - a[0]);
    }

    private boolean isSame(int[] a, int[] b) {
        return a[0] == b[0] && a[1] == b[1];
    }

    public int maxPoints(int[][] points) {
        if(points.length < 3) {
            return points.length;
        }
        int maxPoint = 0;
        for (int i = 0; i < points.length; i++) {
            int same = 0;
            int localMax = 0;
            Map<Double, Integer> slopeCounts = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                if (isSame(points[i], points[j])) {
                    same++;
                    continue;
                }
                double slope = getSlope(points[i], points[j]);
                slopeCounts.put(slope, slopeCounts.getOrDefault(slope, 1) + 1);
                localMax = Math.max(localMax, slopeCounts.get(slope));
            }
            maxPoint = Math.max(localMax + same, maxPoint);
            System.out.println(slopeCounts);
        }

        return maxPoint;
    }
}
