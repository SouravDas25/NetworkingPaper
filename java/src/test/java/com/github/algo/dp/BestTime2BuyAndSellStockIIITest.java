package com.github.algo.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BestTime2BuyAndSellStockIIITest {

    @Test
    void maxProfit() {
        BestTime2BuyAndSellStockIII bestTime2BuyAndSellStockIII = new BestTime2BuyAndSellStockIII();
        int i = bestTime2BuyAndSellStockIII.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4});
        System.out.println(i);
    }
}