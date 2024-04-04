package com.github.algo.slidingwindow;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int cp : prices) {
            minPrice = Math.min(minPrice, cp);
            maxProfit = Math.max(maxProfit, cp - minPrice);
        }
        return maxProfit;
    }
}
