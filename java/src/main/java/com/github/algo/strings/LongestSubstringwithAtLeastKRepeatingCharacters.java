package com.github.algo.strings;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class LongestSubstringwithAtLeastKRepeatingCharacters {

    public int longestSubstring(String s, int k) {
        if (s.length() < 1) {
            return 0;
        }
        Map<String, Long> collect = s.chars().boxed().collect(Collectors.groupingBy(Character::toString, Collectors.counting()));
        Optional<String> pivot = collect.entrySet().stream()
                .filter(entry -> entry.getValue() < k)
                .map(Map.Entry::getKey)
                .findFirst();
        System.out.println(s);
        if (pivot.isPresent()) {
            String[] split = s.split(pivot.get());
            System.out.println(Arrays.toString(split));
            int max = 0;
            for (int i = 0; i < split.length; i++) {
                max = Math.max(longestSubstring(split[i], k), max);
            }
            return max;
        }
        return s.length();
    }

}
