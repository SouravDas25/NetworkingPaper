package com.github.algo.arrays;

import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ShuffleAnArrayTest {

    @Test
    void shuffle() throws NoSuchAlgorithmException {
        ShuffleAnArray shuffleAnArray = new ShuffleAnArray(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(shuffleAnArray.shuffle()));
        System.out.println(Arrays.toString(shuffleAnArray.reset()));
    }
}