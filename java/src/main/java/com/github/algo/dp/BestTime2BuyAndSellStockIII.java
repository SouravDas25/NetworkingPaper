package com.github.algo.dp;

import org.javatuples.Pair;

import java.util.HashMap;
import java.util.Map;

public class BestTime2BuyAndSellStockIII {

    Map<String, Integer> cache = new HashMap<>();

    private int dfs(int i, int trn, int[] prices, int currentPrice) {
        if (i >= prices.length) {
            return currentPrice;
        }
        if (trn == 5) {
            return currentPrice;
        }
        String key = String.format("%d%d%d", i, trn, currentPrice);
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        int d1 = 0;
        if (trn == 1 || trn == 3) {
            d1 = dfs(i + 1, trn + 1, prices, currentPrice - prices[i]);
        } else if (trn == 2 || trn == 4) {
            d1 = dfs(i + 1, trn + 1, prices, currentPrice + prices[i]);
        }
        int d2 = dfs(i + 1, trn, prices, currentPrice);
        int max = Math.max(d1, d2);
        cache.put(key, max);
        return max;
    }

    public int maxProfit(int[] prices) {
        cache.clear();
        return dfs(0, 1, prices, 0);
    }
}
