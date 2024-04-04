package com.github.algo.twopointer;

import java.util.Objects;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        int i = 0, ri = s.length() - 1;
        while (i < ri) {
            char leftChar = Character.toLowerCase(s.charAt(i));
            char rightChar =  Character.toLowerCase(s.charAt(ri));
            if (Character.isLetterOrDigit(leftChar)) {
                if (Character.isLetterOrDigit(rightChar)) {
                    if (rightChar != leftChar) {
                        return false;
                    } else {
                        i++;
                        ri--;
                    }
                } else {
                    ri--;
                }
            } else {
                i++;
            }
        }
        return true;
    }

}
