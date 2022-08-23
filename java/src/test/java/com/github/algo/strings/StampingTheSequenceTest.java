package com.github.algo.strings;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StampingTheSequenceTest {

    @Test
    void movesToStamp() {
        StampingTheSequence stampingTheSequence = new StampingTheSequence();
        int[] ints = stampingTheSequence.movesToStamp("lemk", "lleme");
        System.out.println(Arrays.toString(ints));
    }
}