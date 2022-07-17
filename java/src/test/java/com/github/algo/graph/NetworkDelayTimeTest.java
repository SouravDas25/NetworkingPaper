package com.github.algo.graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NetworkDelayTimeTest {

    @Test
    void networkDelayTime() {
        NetworkDelayTime networkDelayTime = new NetworkDelayTime();
        int[][] times = {{1,2,1}};
        int i = networkDelayTime.networkDelayTime(times, 2, 2);
        System.out.println(i);
    }
}