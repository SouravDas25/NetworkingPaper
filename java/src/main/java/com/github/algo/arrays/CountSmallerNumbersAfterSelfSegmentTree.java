package com.github.algo.arrays;

import com.github.algo.trees.SegmentTree;

import java.util.*;

public class CountSmallerNumbersAfterSelfSegmentTree {

    public List<Integer> countSmaller(int[] nums) {
        IntSummaryStatistics is = Arrays.stream(nums).summaryStatistics();
        SegmentTree segmentTree = new SegmentTree(is.getMin(), is.getMax(), 0);
        List<Integer> output = new ArrayList<>(4);
        for (int i = nums.length - 1; i >= 0; i--) {
            int val = segmentTree.get(is.getMin(), nums[i] - 1, (l, r, c) -> l + r);
            output.add(val);
            segmentTree.update(nums[i], a -> a + 1);
        }
        Collections.reverse(output);
        return output;
    }

}
