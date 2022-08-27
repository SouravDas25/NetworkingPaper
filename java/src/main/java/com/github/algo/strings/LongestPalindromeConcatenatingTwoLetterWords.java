package com.github.algo.strings;


import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class LongestPalindromeConcatenatingTwoLetterWords {

    public int longestPalindrome(String[] words) {
        Map<String, Long> collect = Arrays.stream(words).collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));
        int centreLength = 0;
        int sideLength = 0;
        while (!collect.isEmpty()) {
            Map.Entry<String, Long> entry = collect.entrySet().stream().findFirst().get();
            String word = entry.getKey();
            if (word.charAt(0) == word.charAt(1)) {
                centreLength = (int) Math.max(2 * (entry.getValue() % 2), centreLength);
                sideLength += 4 * (entry.getValue() / 2);
                collect.remove(word);
            } else {
                String rev = new StringBuilder(word).reverse().toString();
                sideLength += 4 * Math.min(collect.getOrDefault(rev, 0L), collect.get(word));
                collect.remove(word);
                collect.remove(rev);
            }
        }
        return centreLength + sideLength;
    }

}
