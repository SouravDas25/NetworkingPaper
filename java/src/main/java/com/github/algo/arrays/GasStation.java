package com.github.algo.arrays;

public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int net = 0, sum = 0;
        int changeI = -1;
        for (int i = 0; i < gas.length; i++) {
            int d = gas[i] - cost[i];
            net += d;
            sum += d;
            if (sum < 0) {
                sum = 0;
                changeI = i + 1;
            }
        }
        return net < 0 ? -1 : changeI;
    }

}
