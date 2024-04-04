package com.github.algo.twopointer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidPalindromeTest {

    @Test
    void isPalindrome() {
        ValidPalindrome validPalindrome= new ValidPalindrome();
        boolean palindrome = validPalindrome.isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(palindrome);
    }
}