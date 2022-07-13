package com.github.algo.backtracking;

import java.util.*;

public class Matchsticks2Square {

    private int[] matchsticks;
    private Map<String, Boolean> cache = new HashMap<>();
    private int target = 0;

    private boolean dfs(int i, int u, int d, int l, int r) {
        if (i < 0) {
            return u != 0 && u == d && u == l && u == r;
        }
        if (u > target || d > target || l > target || r > target) {
            return false;
        }
        boolean b = false;
        if (u + matchsticks[i] <= target) {
            b = b || dfs(i - 1, u + matchsticks[i], d, l, r);
        }
        if (b) return true;
        if (d + matchsticks[i] <= target) {
            b = b || dfs(i - 1, u, d + matchsticks[i], l, r);
        }
        if (b) return true;
        if (l + matchsticks[i] <= target) {
            b = b || dfs(i - 1, u, d, l + matchsticks[i], r);
        }
        if (b) return true;
        if (r + matchsticks[i] <= target) {
            b = b || dfs(i - 1, u, d, l, r + matchsticks[i]);
        }
        if (b) return true;

        return b;
    }

    public boolean makesquare(int[] matchsticks) {
        this.matchsticks = matchsticks;

        cache.clear();
        int total = 0;

        for (int i : matchsticks) {
            total += i;
        }

        if (total % 4 != 0) return false;
        target = total / 4;
        Arrays.sort(this.matchsticks);

        return dfs(matchsticks.length - 1, 0, 0, 0, 0);
    }

}
