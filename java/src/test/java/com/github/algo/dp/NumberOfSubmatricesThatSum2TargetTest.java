package com.github.algo.dp;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

class NumberOfSubmatricesThatSum2TargetTest {

    @Test
    void numSubmatrixSumTarget() {
        NumberOfSubmatricesThatSum2Target numberOfSubmatricesThatSum2Target = new NumberOfSubmatricesThatSum2Target();
        int[][] matrix = {{1,-1},{-1,1}};
        int i = numberOfSubmatricesThatSum2Target.numMatrixSumTarget(matrix, 0);
        System.out.println(i);
    }

    @Test
    void kjabsd() {
        String line = "1,2,3,4,5:2";
        String[] split = line.split(":");
        String[] split1 = split[0].split(",");
        List<Integer> collect = Arrays.stream(split1).map(Integer::parseInt).collect(Collectors.toList());
        Collections.reverse(collect.subList(0, 2));
        Iterator<Integer> iterator = collect.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.print(next);
            if(iterator.hasNext()) System.out.print(",");
        }
    }

}