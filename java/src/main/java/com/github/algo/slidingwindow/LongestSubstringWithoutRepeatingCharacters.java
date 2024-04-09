package com.github.algo.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        int j = 0;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char cc = s.charAt(i);
            while (window.contains(cc)) {
                window.remove(s.charAt(j++));
            }
            window.add(cc);
            maxLength = Math.max(maxLength, window.size());
        }
        return maxLength;
    }
}
