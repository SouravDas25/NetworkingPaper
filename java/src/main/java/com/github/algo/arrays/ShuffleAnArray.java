package com.github.algo.arrays;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;

public class ShuffleAnArray {

    private int[] original;
    private int[] shuffled;
    private Random random;

    public ShuffleAnArray(int[] nums) {
        this.original = nums;
        shuffled = Arrays.copyOf(original, original.length);
        try {
            random = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            random = new Random(Instant.now().toEpochMilli());
        }
    }

    public int[] reset() {
        return original;
    }

    private void swap(int i, int j) {
        int tmp = shuffled[i];
        shuffled[i] = shuffled[j];
        shuffled[j] = tmp;
    }

    public int[] shuffle() {
        for (int i = 0; i < shuffled.length; i++) {
            int j = Math.abs(random.nextInt()) % shuffled.length;
            swap(i, j);
        }
        return shuffled;
    }

}
