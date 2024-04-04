package com.github.algo.strings;

public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        s = s.stripTrailing();
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                return count;
            }
            count++;
        }
        return count;
    }

}
