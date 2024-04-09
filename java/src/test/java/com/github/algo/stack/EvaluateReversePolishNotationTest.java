package com.github.algo.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EvaluateReversePolishNotationTest {

    @Test
    void evalRPN() {
        EvaluateReversePolishNotation evaluateReversePolishNotation = new EvaluateReversePolishNotation();
        int i = evaluateReversePolishNotation.evalRPN(new String[]{"2", "1", "+", "3", "*"});
        assertEquals(9, i);
    }
}