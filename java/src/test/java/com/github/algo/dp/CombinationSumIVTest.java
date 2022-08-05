package com.github.algo.dp;

import com.github.algo.dp.CombinationSumIV;
import org.junit.jupiter.api.Test;

class CombinationSumIVTest {

    @Test
    void combinationSum4() {
        CombinationSumIV combinationSumIV = new CombinationSumIV();
        int i = combinationSumIV.combinationSum4(new int[]{1, 2, 3}, 4);
        System.out.println(i);
    }
}