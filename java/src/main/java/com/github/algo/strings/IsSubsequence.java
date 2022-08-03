package com.github.algo.strings;

public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        if (s.length() < 1) return true;
        int count = 0;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(count)) {
                count++;
            }
            if (count == s.length()) {
                return true;
            }
        }
        return count == s.length();
    }

}
