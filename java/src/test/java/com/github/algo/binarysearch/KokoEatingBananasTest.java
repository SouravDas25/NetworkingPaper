package com.github.algo.binarysearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KokoEatingBananasTest {

    @Test
    void minEatingSpeed() {
        KokoEatingBananas kokoEatingBananas = new KokoEatingBananas();
        int i = kokoEatingBananas.minEatingSpeed(new int[]{3, 6, 7, 11}, 8);
        assertEquals(4, i);
    }

    @Test
    void minEatingSpeed2() {
        KokoEatingBananas kokoEatingBananas = new KokoEatingBananas();
        int i = kokoEatingBananas.minEatingSpeed(new int[]{1000000000}, 2);
        assertEquals(500000000, i);


    }
}