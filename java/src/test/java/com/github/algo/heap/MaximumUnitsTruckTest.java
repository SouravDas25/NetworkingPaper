package com.github.algo.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumUnitsTruckTest {

    @Test
    void maximumUnits() {
        MaximumUnitsTruck maximumUnitsTruck = new MaximumUnitsTruck();
        int[][] boxes = {{1,3},{2,2},{3,1}};
        int i = maximumUnitsTruck.maximumUnits(boxes, 4);
        System.out.println(i);
    }
}