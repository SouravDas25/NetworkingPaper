package com.github.algo.strings;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        int maxLength = 0;
        int str = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int j = 0, l = 1;
            while (i - j >= 0 && i + j < s.length()) {
                if (s.charAt(i - j) != s.charAt(i + j)) {
                    break;
                }
                l = 2 * j + 1;
                if (maxLength < l) {
                    maxLength = l;
                    str = i - j;
                    end = i + j + 1;
                }
                j++;
            }
            int k = i + 1;
            j = i;
            l = 0;
            while (j >= 0 && k < s.length()) {
                if (s.charAt(j) != s.charAt(k)) {
                    break;
                }
                l += 2;
                if (maxLength < l) {
                    maxLength = l;
                    str = j;
                    end = k + 1;
                }
                j--;
                k++;
            }
        }
        return s.substring(str, end);
    }

}
