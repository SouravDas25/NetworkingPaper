package com.github.algo.commons;

import java.util.*;

public class MinimumNumberOfRefuelingStops {

    PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt((int[] arr) -> arr[0]).reversed());
    int i = 0;

    private void dfs(int currentFuel, int noOfRefueling, int[] refuelStops, int[][] stations) {
        if (noOfRefueling >= refuelStops.length) {
            return;
        }
        for (; i < stations.length; i++) {
            int nextStationDistance = stations[i][0];
            int nextGas = stations[i][1];
            if (nextStationDistance > currentFuel) {
                break;
            }
            heap.add(new int[]{nextGas, i});
        }
        if (!heap.isEmpty()) {
            int[] poll = heap.poll();
            int gas = poll[0];
            refuelStops[noOfRefueling] = currentFuel + gas;
            dfs(currentFuel + gas, noOfRefueling + 1, refuelStops, stations);
        }
    }

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (target <= startFuel) {
            return 0;
        }
        int[] refuelStops = new int[stations.length + 1];
        Arrays.fill(refuelStops, -1);
        refuelStops[0] = startFuel;
        Arrays.sort(stations, Comparator.comparingInt(arr -> arr[0]));
        dfs(startFuel, 1, refuelStops, stations);

        System.out.println(Arrays.toString(refuelStops));

        for (int i = 0; i < refuelStops.length; i++) {
            if (refuelStops[i] >= target) {
                return i;
            }
        }

        return -1;
    }

}
