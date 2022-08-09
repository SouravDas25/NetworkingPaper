package com.github.algo.trees;

import com.github.algo.interfaces.TernaryOperator;

import java.util.Arrays;
import java.util.function.UnaryOperator;

public class SegmentTree {

    private int[] segments;
    private int low;
    private int high;
    private int defaultVal;

    public SegmentTree(int low, int high, int defaultVal) {
        this.low = low;
        this.high = high;
        segments = new int[(high - low) * 4 + 1];
        this.defaultVal = defaultVal;
        Arrays.fill(segments, defaultVal);
    }

    private void updateSegment(int key, int segmentIndex, int left, int right, UnaryOperator<Integer> lambda) {
        if (key < left || right < key) {
            return;
        }
        segments[segmentIndex] = lambda.apply(segments[segmentIndex]);
        if (right != left) {
            int mid = (left + right) >> 1;
            updateSegment(key, 2 * segmentIndex + 1, left, mid, lambda);
            updateSegment(key, 2 * segmentIndex + 2, mid + 1, right, lambda);
        }
    }

    public void update(int key, UnaryOperator<Integer> lambda) {
        updateSegment(key, 0, low, high, lambda);
    }

    private static boolean isOverlap(int l, int r, int left, int right) {
        return r >= left && right >= l;
    }

    private int getValue(int l, int r, int left, int right, int segmentIndex, TernaryOperator<Integer> lambda) {
        if (l == left && r == right) {
            return segments[segmentIndex];
        }
        if (isOverlap(l, r, left, right)) {
            int mid = (left + right) >> 1;
            int lv = getValue(Math.max(l, left), Math.min(r, mid), left, mid, 2 * segmentIndex + 1, lambda);
            int rv = getValue(Math.max(l, mid + 1), Math.min(r, right), mid + 1, right, 2 * segmentIndex + 2, lambda);
            return lambda.apply(lv, rv, segments[segmentIndex]);
        }
        return defaultVal;
    }

    public int get(int l, int r, TernaryOperator<Integer> lambda) {
        return getValue(l, r, low, high, 0, lambda);
    }
}
