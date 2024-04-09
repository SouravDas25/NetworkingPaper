package com.github.algo.slidingwindow;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MinimumWindowSubstring {

    public static <K, V extends Comparable> boolean mapContains(Map<K, V> bigger, Map<K, V> smaller) {
        if (bigger.size() < smaller.size()) return false;
        // Iterate over entries in bigger
        for (Map.Entry<K, V> entry : smaller.entrySet()) {
            K key = entry.getKey();
            V value1 = entry.getValue();
            if (!bigger.containsKey(key)) {
                return false;
            }
            V value2 = bigger.get(key);
            // If key is not present in smaller or values are different, maps are not equal
            if (value1.compareTo(value2) > 0) {
                return false;
            }
        }
        // If all keys and values match, maps are equal
        return true;
    }

    public String minWindow(String s, String t) {
        Map<Character, Long> cmpMap = t.chars().boxed()
                .collect(Collectors
                        .groupingBy(
                                i -> Character.valueOf((char) i.intValue()),
                                Collectors.counting()
                        )
                );
        Map<Character, Long> window = new HashMap<>();
        int j = 0, ws = 0;
        int minLength = Integer.MAX_VALUE;
        String substring = "";
        for (int i = 0; i < s.length(); i++) {
            char cc = s.charAt(i);
            window.putIfAbsent(cc, 0L);
            window.put(cc, window.get(cc) + 1);
            ws++;
            while (mapContains(window, cmpMap)) {
                if (ws < minLength) {
                    minLength = Math.min(minLength, ws);
                    substring = s.substring(j, i + 1);
                }
                char oc = s.charAt(j);
                window.put(oc, window.get(oc) - 1);
                ws--;
                j++;
            }
        }
        return substring;
    }
}
