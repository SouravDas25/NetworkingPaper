package com.github.algo.backtracking;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LetterCombinationsOfPhoneNumberTest {

    @Test
    void letterCombinations() {
        LetterCombinationsOfPhoneNumber letterCombinationsOfPhoneNumber = new LetterCombinationsOfPhoneNumber();
        List<String> strings = letterCombinationsOfPhoneNumber.letterCombinations("23");
        System.out.println(strings);
    }
}