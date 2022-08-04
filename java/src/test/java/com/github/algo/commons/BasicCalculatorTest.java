package com.github.algo.commons;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasicCalculatorTest {

    @Test
    void calculate() {
        String s = "- (3 - (4 + 5) )";
        BasicCalculator basicCalculator = new BasicCalculator();
        basicCalculator.calculate(s);
    }
}