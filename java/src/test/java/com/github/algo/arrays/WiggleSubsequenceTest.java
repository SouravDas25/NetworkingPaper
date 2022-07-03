package com.github.algo.arrays;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WiggleSubsequenceTest {

    @Test
    void wiggleMaxLength() {
        WiggleSubsequence wiggleSubsequence = new WiggleSubsequence();
        int ans = wiggleSubsequence.wiggleMaxLength(new int[]{1, 1, 1});
        assertThat(ans).isEqualTo(1);

        ans = wiggleSubsequence.wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5});
        assertThat(ans).isEqualTo(6);

        ans = wiggleSubsequence.wiggleMaxLength(new int[]{3, 3, 3, 2, 5});
        assertThat(ans).isEqualTo(3);

        ans = wiggleSubsequence.wiggleMaxLength(new int[]{1, 1, 1});
        assertThat(ans).isEqualTo(1);

        ans = wiggleSubsequence.wiggleMaxLength(new int[]{1, 1, 1});
        assertThat(ans).isEqualTo(1);
    }
}