package com.github.algo.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoinChangeII {

    record Memo(int j, int amount) {
    }

    Map<Memo, Integer> cache = new HashMap<>();

    int[] coins;

    int dfs(int j, int amount) {
        if (amount == 0) return 1;
        if (amount < 0) return 0;
        Memo memo = new Memo(j, amount);
        if (cache.containsKey(memo)) {
            return cache.get(memo);
        }
        int ways = 0;
        for (int i = j; i < coins.length; i++) {
            if (amount - coins[i] < 0) {
                break;
            }
            ways += dfs(i, amount - coins[i]);
        }
        cache.put(memo, ways);
        return ways;
    }

    public int change(int amount, int[] coins) {
        this.coins = Arrays.stream(coins).sorted().toArray();
        return dfs(0, amount);
    }

}
