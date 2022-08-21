package com.github.algo.commons;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumNumberOfRefuelingStopsTest {

    @Test
    void minRefuelStops() {
        MinimumNumberOfRefuelingStops minimumNumberOfRefuelingStops = new MinimumNumberOfRefuelingStops();
        int i = minimumNumberOfRefuelingStops.minRefuelStops(1000, 83,
                new int[][]{{25,27},{36,187},{140,186},{378,6},{492,202},{517,89},{579,234},{673,86},{808,53},{954,49}});
        System.out.println(i);
    }
}