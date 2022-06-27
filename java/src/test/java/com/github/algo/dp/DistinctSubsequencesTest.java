package com.github.algo.dp;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DistinctSubsequencesTest {

    @Test
    void numDistinct() {
        DistinctSubsequences distinctSubsequences = new DistinctSubsequences();
        int i = distinctSubsequences.numDistinct("rabbbit", "rabbit");
        assertThat(i).isEqualTo(3);
    }
}