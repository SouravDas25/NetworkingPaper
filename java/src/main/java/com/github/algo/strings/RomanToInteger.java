package com.github.algo.strings;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    static Map<Character, Integer> romanNumbers = new HashMap<>();

    static {
        romanNumbers.put('I', 1);
        romanNumbers.put('V', 5);
        romanNumbers.put('X', 10);
        romanNumbers.put('L', 50);
        romanNumbers.put('C', 100);
        romanNumbers.put('D', 500);
        romanNumbers.put('M', 1000);
    }

    public int romanToInt(String s) {
        int number = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int v = romanNumbers.get(ch);
            if (i + 1 < s.length() && romanNumbers.get(s.charAt(i + 1)) > v) {
                int nv = romanNumbers.get(s.charAt(i + 1));
                number += nv - v;
                i++;
            } else {
                number += v;
            }
        }
        return number;
    }

}
