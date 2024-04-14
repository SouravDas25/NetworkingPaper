package com.github.algo.dp;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EditDistanceRecursionTest {

    @Test
    void minDistance() {
        EditDistanceRecursion editDistance = new EditDistanceRecursion();
        int i = editDistance.minDistance("horse", "ros");
        assertThat(i).isEqualTo(3);
    }
}