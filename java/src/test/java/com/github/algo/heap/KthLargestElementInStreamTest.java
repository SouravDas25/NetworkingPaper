package com.github.algo.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KthLargestElementInStreamTest {

    @Test
    void add() {
        KthLargestElementInStream kthLargestElementInStream = new KthLargestElementInStream(
                3, new int[]{4, 5, 8, 2}
        );
        assertEquals(4, kthLargestElementInStream.add(3));
        assertEquals(5, kthLargestElementInStream.add(5));
        assertEquals(5, kthLargestElementInStream.add(10));
        assertEquals(8, kthLargestElementInStream.add(9));
        assertEquals(8, kthLargestElementInStream.add(4));
    }
}