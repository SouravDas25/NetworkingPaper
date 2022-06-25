package com.github.algo.arrays;

import java.util.HashMap;

public class Anagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> characterCount = new HashMap<>();
        for (final char c : s.toCharArray()) {
            characterCount.putIfAbsent(c, 0);
            characterCount.put(c, characterCount.get(c) + 1);
        }
        for (final char c : t.toCharArray()) {
            if (!characterCount.containsKey(c)) {
                return false;
            }
            characterCount.put(c, characterCount.get(c) - 1);
            if (characterCount.get(c) <= 0) {
                characterCount.remove(c);
            }
        }
        return characterCount.isEmpty();
    }

}
