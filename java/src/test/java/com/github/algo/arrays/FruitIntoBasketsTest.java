package com.github.algo.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FruitIntoBasketsTest {

    @Test
    void totalFruit() {
        FruitIntoBaskets fruitIntoBaskets = new FruitIntoBaskets();
        int i = fruitIntoBaskets.totalFruit(new int[]{1, 2, 3, 2, 2});
        System.out.println(i);
    }
}