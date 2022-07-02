package com.github.algo.arrays;

import java.util.*;
import java.util.stream.Collectors;

public class MaximumAreaInCake {

    public long maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        List<Integer> horizontalCutsList = Arrays.stream(horizontalCuts).boxed().collect(Collectors.toList());
        List<Integer> verticalCutsList = Arrays.stream(verticalCuts).boxed().collect(Collectors.toList());
        Collections.sort(horizontalCutsList);
        Collections.sort(verticalCutsList);
        horizontalCutsList.add(h);
        verticalCutsList.add(w);
        Integer left, top = 0;
        long max = 0;
        for (Integer horizontalCut : horizontalCutsList) {
            left = 0;
            for (Integer verticalCut : verticalCutsList) {
                long area = (long) (horizontalCut - top) * (verticalCut - left);
                max = Math.max(area, max);
                left = verticalCut;
            }
            top = horizontalCut;
        }
        return Long.valueOf(max % 1000000007L).intValue();
    }

}
