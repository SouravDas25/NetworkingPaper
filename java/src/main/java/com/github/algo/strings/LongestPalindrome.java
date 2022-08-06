package com.github.algo.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LongestPalindrome {

    public int longestPalindrome(String s) {
        Map<Character, Integer> counts = new HashMap<>(50);
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        System.out.println(counts);
        Map<Boolean, Integer> partitions = new HashMap<>(10);
        counts.entrySet().forEach(e -> {
            partitions.put(false, partitions.getOrDefault(false, 0) + (e.getValue() % 2));
            partitions.put(true, partitions.getOrDefault(true, 0) + (e.getValue() / 2) * 2);
        });
        System.out.println(partitions);
        if (partitions.get(false) == 0) {
            return partitions.get(true);
        }
        return partitions.get(true) + 1;
    }

}
