package com.github.algo.trees;

public class RangeSumQueryMutable {

    private final SegmentTree segmentTree;
    private final int[] nums;

    public RangeSumQueryMutable(int[] nums) {
        this.nums = nums;
        segmentTree = new SegmentTree(0, nums.length, 0);
        for (int i = 0; i < nums.length; i++) {
            int finalI = i;
            segmentTree.update(i, a -> a + nums[finalI]);
        }
    }

    public void update(int index, int val) {
        int diff = val - nums[index];
        nums[index] = val;
        segmentTree.update(index, a -> a + diff);
    }

    public int sumRange(int left, int right) {
        return segmentTree.get(left, right, (l, r, c) -> l + r);
    }
}
