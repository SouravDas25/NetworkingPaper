package com.github.algo.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PartitionEqualSubsetSumTest {

    @Test
    void canPartition() {
        PartitionEqualSubsetSum partitionEqualSubsetSum = new PartitionEqualSubsetSum();
        boolean b = partitionEqualSubsetSum.canPartition(new int[]{1, 5, 11, 5});
        assertTrue(b);
    }

    @Test
    void canPartition1() {
        PartitionEqualSubsetSum partitionEqualSubsetSum = new PartitionEqualSubsetSum();
        boolean b = partitionEqualSubsetSum.canPartition(new int[]{1, 2, 3, 5});
        assertFalse(b);
    }
}