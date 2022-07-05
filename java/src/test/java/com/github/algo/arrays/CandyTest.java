package com.github.algo.arrays;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CandyTest {

    @Test
    void candy() {
        int[] ratings = {1, 0, 2};
        Candy candy = new Candy();
        int candy1 = candy.candy(ratings);
        System.out.println(candy1);
    }
}