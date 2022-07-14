package com.github.algo.backtracking;

import java.util.*;

public class LetterCombinationsOfPhoneNumber {

    public static Map<Character, List<Character>> digitsMap = new HashMap<>();

    static {
        digitsMap.put('2', Arrays.asList('a', 'b', 'c'));
        digitsMap.put('3', Arrays.asList('d', 'e', 'f'));
        digitsMap.put('4', Arrays.asList('g', 'h', 'i'));
        digitsMap.put('5', Arrays.asList('j', 'k', 'l'));
        digitsMap.put('6', Arrays.asList('m', 'n', 'o'));
        digitsMap.put('7', Arrays.asList('p', 'q', 'r', 's'));
        digitsMap.put('8', Arrays.asList('t', 'u', 'v'));
        digitsMap.put('9', Arrays.asList('w', 'x', 'y', 'z'));
    }

    private void dfs(int i, String digits, String current, List<String> output) {
        if (i == digits.length()) {
            output.add(current);
            return;
        }
        Character character = digits.charAt(i);
        List<Character> characters = digitsMap.get(character);
        for (Character c : characters) {
            dfs(i + 1, digits, current + c, output);
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() <= 0) {
            return Collections.emptyList();
        }
        List<String> output = new LinkedList<>();
        dfs(0, digits, "", output);
        return output;
    }
}
