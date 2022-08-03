package com.github.algo.strings;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> mapping1 = new HashMap<>(26);
        Map<Character, Character> mapping2 = new HashMap<>(26);
        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            if (mapping1.containsKey(ch1) && ch2 != mapping1.get(ch1)) {
                return false;
            }
            if (mapping2.containsKey(ch2) && ch1 != mapping2.get(ch2)) {
                return false;
            }
            mapping1.put(ch1, ch2);
            mapping2.put(ch2, ch1);
        }
        return true;
    }

}
