package com.github.algo.dp;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EditDistanceTest {

    @Test
    void minDistance() {
        EditDistance editDistance = new EditDistance();
        int i = editDistance.minDistance("horse", "ros");
        assertThat(i).isEqualTo(3);
    }
}