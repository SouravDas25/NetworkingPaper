package com.github.algo.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MaximumUnitsTruck {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        List<int[]> objects = Arrays.stream(boxTypes)
                .sorted(Comparator.comparing(a -> a[1], Comparator.reverseOrder()))
                .collect(Collectors.toList());
//        objects.stream().map(Arrays::toString).forEach(System.out::println);
        int count = 0;
        for (int[] object : objects) {
            if (object[0] <= truckSize) {
                count += object[0] * object[1];
                truckSize -= object[0];
            } else {
                count += truckSize * object[1];
                break;
            }
        }
        return count;
    }
}
