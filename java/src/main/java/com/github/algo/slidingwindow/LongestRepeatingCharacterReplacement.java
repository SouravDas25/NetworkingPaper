package com.github.algo.slidingwindow;

import org.checkerframework.checker.units.qual.C;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int j = 0, ws = 0, maxFreq = 0, maxLength = 0;
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char cc = s.charAt(i);
            window.putIfAbsent(cc, 0);
            window.put(cc, window.get(cc) + 1);
            maxFreq = Math.max(maxFreq, window.get(cc));
            ws++;
            int op = ws - maxFreq;
            if (op <= k) {
                maxLength = Math.max(ws, maxLength);
            } else {
                while (op > k) {
                    char oc = s.charAt(j);
                    window.put(oc, window.get(oc) - 1);
                    ws--;
                    maxFreq = Math.max(maxFreq, window.get(cc));
                    op = ws - maxFreq;
                    j++;
                }
            }
        }
        return maxLength;
    }

}
