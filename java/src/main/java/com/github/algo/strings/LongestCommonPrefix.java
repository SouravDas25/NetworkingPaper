package com.github.algo.strings;

public class LongestCommonPrefix {

    private String longestCommonPrefix(String a, String b) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.min(a.length(), b.length()); i++) {
            if (a.charAt(i) == b.charAt(i)) {
                sb.append(a.charAt(i));
            } else {
                break;
            }
        }
        return sb.toString();
    }

    public String longestCommonPrefix(String[] strs) {
        String lc = strs[0];
        for (String str : strs) {
            lc = longestCommonPrefix(lc, str);
        }
        return lc;
    }
}
