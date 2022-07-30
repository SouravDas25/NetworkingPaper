package com.github.algo.backtracking;

import java.util.HashMap;
import java.util.Map;

public class CountAndSay {

    private static Map<Integer, String> cache = new HashMap<>();

    static {
        cache.put(1, "1");
        cache.put(2, "11");
        cache.put(3, "21");
        cache.put(4, "1211");
    }

    public String countAndSay(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        String previousString = countAndSay(n - 1);
        StringBuilder stringBuilder = new StringBuilder();
        int count = 1;
        for (int i = 1; i < previousString.length(); i++) {
            if (previousString.charAt(i) != previousString.charAt(i - 1)) {
                stringBuilder.append(count).append(previousString.charAt(i - 1));
                count = 1;
            } else {
                count++;
            }
        }
        stringBuilder.append(count).append(previousString.charAt(previousString.length() - 1));
        cache.put(n, stringBuilder.toString());
        return cache.get(n);
    }

}
