package com.github.algo.mathgeometry;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountPrimesTest {

    @Test
    void countPrimes() {
        CountPrimes countPrimes = new CountPrimes();
        int i;
        i = countPrimes.countPrimes((int) Math.pow(10, 2));
        System.out.println(i);

        i = countPrimes.countPrimes((int) Math.pow(10, 2));
        System.out.println(i);

        i = countPrimes.countPrimes(23);
        System.out.println(i);

    }
}