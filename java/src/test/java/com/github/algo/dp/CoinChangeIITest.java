package com.github.algo.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoinChangeIITest {

    @Test
    void change() {
        CoinChangeII coinChangeII = new CoinChangeII();
        int change = coinChangeII.change(5, new int[]{1, 2, 5});
        assertEquals(4, change);
    }
}