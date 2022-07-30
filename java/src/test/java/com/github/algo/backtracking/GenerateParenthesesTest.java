package com.github.algo.backtracking;

import org.junit.jupiter.api.Test;

import java.util.List;

class GenerateParenthesesTest {

    @Test
    void generateParenthesis() {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        List<String> strings = generateParentheses.generateParenthesis(3);
        System.out.println(strings);
    }
}