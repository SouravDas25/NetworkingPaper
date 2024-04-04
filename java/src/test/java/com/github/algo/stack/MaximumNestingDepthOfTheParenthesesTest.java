package com.github.algo.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumNestingDepthOfTheParenthesesTest {

    @Test
    void maxDepth() {
        MaximumNestingDepthOfTheParentheses maximumNestingDepthOfTheParentheses = new MaximumNestingDepthOfTheParentheses();
        int i = maximumNestingDepthOfTheParentheses.maxDepth("(1+(2*3)+((8)/4))+1");
        assertEquals(3, i);
    }
}