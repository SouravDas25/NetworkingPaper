package com.github.algo.dp;

import com.github.algo.util.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class RegularExpressionMatchingRecursion {

    record Pattern(Character ch, Integer count) {
    }

    record Memo(int i, int j) {
    }

    private List<Pattern> compile(String pattern) {
        List<Pattern> output = new ArrayList<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == '*') {
                output.set(output.size() - 1, new Pattern(pattern.charAt(i - 1), -1));
            } else {
                output.add(new Pattern(pattern.charAt(i), 1));
            }
        }
        return output;
    }

    Map<Memo, Boolean> cache = new HashMap<>();

    boolean dfs(int i, int j, List<Character> str, List<Pattern> regex) {
        if (cache.containsKey(new Memo(i, j))) {
            return cache.get(new Memo(i, j));
        }
        boolean isRegexEmpty = i >= regex.size();
        boolean isStrEmpty = j >= str.size();
        if (isStrEmpty && isRegexEmpty) {
            cache.put(new Memo(i, j), true);
            return true;
        }
        if (isRegexEmpty) {
            cache.put(new Memo(i, j), false);
            return false;
        }
        Pattern first = regex.get(i);
        // if *
        if (first.count == -1) {
            if (isStrEmpty) {
                boolean result = dfs(i + 1, j, str, regex);
                cache.put(new Memo(i, j), result);
                return result;
            }
            // its match
            if (first.ch == '.' || Objects.equals(first.ch, str.get(j))) {
                boolean usingStar = dfs(i + 1, j, str, regex);
                boolean withoutStar = dfs(i, j + 1, str, regex);
                cache.put(new Memo(i, j), usingStar || withoutStar);
                cache.put(new Memo(i + 1, j), usingStar);
                cache.put(new Memo(i, j + 1), withoutStar);
                return usingStar || withoutStar;
            } else {
                // if not match, move to next regex
                boolean result = dfs(i + 1, j, str, regex);
                cache.put(new Memo(i, j), result);
                return result;
            }
        } else {
            if (isStrEmpty) {
                cache.put(new Memo(i, j), false);
                return false;
            }
            if (first.ch == '.' || Objects.equals(first.ch, str.get(j))) {
                boolean result = dfs(i + 1, j + 1, str, regex);
                cache.put(new Memo(i, j), result);
                return result;
            } else {
                cache.put(new Memo(i, j), false);
                return false;
            }
        }
    }

    public boolean isMatch(String s, String p) {
        List<Pattern> regex = compile(p);
        List<Character> str = s.chars().boxed()
                .map(i -> (char) i.intValue())
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println(regex);
        return dfs(0, 0, str, regex);
    }
}
