package com.github.algo.trees;

public class RangeSumQueryMutable {

    private SegmentTree segmentTree;

    public RangeSumQueryMutable(int[] nums) {
        segmentTree = new SegmentTree(nums.length);
        for (int i = 0; i < nums.length; i++) {
            segmentTree.update(i, nums[i]);
        }
    }

    public void update(int index, int val) {
        segmentTree.update(index, val);
    }

    public int sumRange(int left, int right) {
        return segmentTree.get(left, right);
    }
}
