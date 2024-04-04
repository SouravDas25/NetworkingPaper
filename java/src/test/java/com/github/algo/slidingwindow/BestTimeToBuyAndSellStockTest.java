package com.github.algo.slidingwindow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BestTimeToBuyAndSellStockTest {

    @Test
    void maxProfit() {
        BestTimeToBuyAndSellStock sellStock = new BestTimeToBuyAndSellStock();
        int i = sellStock.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        assertEquals(5, i);
    }
}