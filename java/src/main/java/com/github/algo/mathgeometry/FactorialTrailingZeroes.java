package com.github.algo.mathgeometry;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class FactorialTrailingZeroes {

    private Map<Integer, BigInteger> cache = new HashMap<>();

    private BigInteger factorial(int n) {
        if (n <= 1) {
            return BigInteger.ONE;
        }
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        cache.put(n, factorial(n - 1).multiply(BigInteger.valueOf(n)));
        return cache.get(n);
    }

    public int trailingZeroes(int n) {
        return n == 0 ? 0 : (n / 5) + this.trailingZeroes(n / 5);
    }

}
