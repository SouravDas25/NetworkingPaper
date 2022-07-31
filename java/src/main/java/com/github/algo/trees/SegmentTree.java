package com.github.algo.trees;

public class SegmentTree {

    private final int[] segments;
    private final int n;
    private final int[] nums;

    public SegmentTree(int n) {
        this.n = n;
        segments = new int[4 * n];
        nums = new int[n];
    }

    private void updateSeq(int i, int ci, int left, int right, int diff) {
        if (left > right || i < left || right < i) {
            return;
        }
        segments[ci] += diff;
        if (right != left) {
            int mid = (left + right) >> 1;
            updateSeq(i, 2 * ci + 1, left, mid, diff);
            updateSeq(i, 2 * ci + 2, mid + 1, right, diff);
        }
    }

    public void update(int i, int value) {
        int diff = value - nums[i];
        nums[i] = value;
        updateSeq(i, 0, 0, n - 1, diff);
    }

    boolean isOverlap(int rl, int rr, int left, int right) {
        return rr >= left && right >= rl;
    }

    private int getValue(int rl, int rr, int left, int right, int ci) {
        if (rl == left && rr == right) {
            return segments[ci];
        }
        if (isOverlap(rl, rr, left, right)) {
            int mid = (left + right) >> 1;
            int lv = getValue(Math.max(rl, left), Math.min(rr, mid), left, mid, 2 * ci + 1);
            int rv = getValue(Math.max(rl, mid + 1), Math.min(rr, right), mid + 1, right, 2 * ci + 2);
            return lv + rv;
        }
        return 0;
    }

    public int get(int left, int right) {
        return getValue(left, right, 0, n-1, 0);
    }


}
