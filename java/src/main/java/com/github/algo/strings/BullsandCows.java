package com.github.algo.strings;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BullsandCows {
    public String getHint(String secret, String guess) {
        int a = 0, b = 0;
        Map<Character, Long> charsInSecret = secret.chars().mapToObj(i -> Character.valueOf((char) i))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<Integer> unmatched = new LinkedList<>();
        for (int i = 0; i < guess.length(); i++) {
            char c = guess.charAt(i);
            if (charsInSecret.containsKey(c) && charsInSecret.get(c) > 0) {
                if (c == secret.charAt(i)) {
                    a++;
                    charsInSecret.put(c, charsInSecret.get(c) - 1);
                } else {
                    unmatched.add(i);
                }
            }
        }
        for (Integer i : unmatched) {
            char c = guess.charAt(i);
            if (charsInSecret.containsKey(c) && charsInSecret.get(c) > 0) {
                b++;
                charsInSecret.put(c, charsInSecret.get(c) - 1);
            }
        }
        return String.format("%dA%dB", a, b);
    }
}
