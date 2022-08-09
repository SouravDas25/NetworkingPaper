package com.github.algo.trees;

import com.github.algo.trees.RangeSumQueryMutable;
import org.junit.jupiter.api.Test;

class RangeSumQueryMutableTest {

    @Test
    void update() {
        RangeSumQueryMutable rangeSumQueryMutable = new RangeSumQueryMutable(new int[]{1,3,5,2,1,3});
        int i = rangeSumQueryMutable.sumRange(1, 4);
        System.out.println(i);
        rangeSumQueryMutable.update(1,2);
        i = rangeSumQueryMutable.sumRange(1, 5);
        System.out.println(i);
    }
}