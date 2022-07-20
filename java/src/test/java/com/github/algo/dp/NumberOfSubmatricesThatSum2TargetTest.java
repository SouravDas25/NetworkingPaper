package com.github.algo.dp;

import org.junit.jupiter.api.Test;

class NumberOfSubmatricesThatSum2TargetTest {

    @Test
    void numSubmatrixSumTarget() {
        NumberOfSubmatricesThatSum2Target numberOfSubmatricesThatSum2Target = new NumberOfSubmatricesThatSum2Target();
        int[][] matrix = {{1,-1},{-1,1}};
        int i = numberOfSubmatricesThatSum2Target.numSubmatrixSumTarget(matrix, 0);
        System.out.println(i);
    }
}