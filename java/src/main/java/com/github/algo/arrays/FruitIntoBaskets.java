package com.github.algo.arrays;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {

    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> window = new HashMap<>();
        int i = 0;
        int j = 0;
        int maxCount = 0;
        int count = 0;
        while (i < fruits.length) {
            window.put(fruits[i], window.getOrDefault(fruits[i], 0) + 1);
            count++;
            while (window.size() > 2) {
                window.put(fruits[j], window.get(fruits[j]) - 1);
                if (window.get(fruits[j]) <= 0) {
                    window.remove(fruits[j]);
                }
                count--;
                j++;
            }
            i++;
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }
}
