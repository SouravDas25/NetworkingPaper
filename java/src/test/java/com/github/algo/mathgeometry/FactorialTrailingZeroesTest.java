package com.github.algo.mathgeometry;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTrailingZeroesTest {

    @Test
    void trailingZeroes() {
        FactorialTrailingZeroes factorialTrailingZeroes = new FactorialTrailingZeroes();
        for (int i = 0; i < 200; i+=5) {
            int bigInteger = factorialTrailingZeroes.trailingZeroes(i);
            System.out.println(i + " : " + bigInteger + " : " + i / 5);
        }
    }
}