package com.github.algo.graph;

import org.javatuples.Pair;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.function.Function;

public class RottingOranges {

    private int[][] movements = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        Deque<Pair<Integer, Integer>> queue = new LinkedList<>();
        int goodOranges = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) grid[i][j] = -2;
                if (grid[i][j] == 2) {
                    grid[i][j] = 0;
                    queue.add(Pair.with(i, j));
                }
                if (grid[i][j] == 1) {
                    grid[i][j] = -1;
                    goodOranges++;
                }
            }
        }
        int maxMinutes = 0;
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.removeFirst();
            int i = pair.getValue0();
            int j = pair.getValue1();
            for (int[] move : movements) {
                int di = i + move[0], dj = j + move[1];
                if (di < grid.length && di >= 0 && dj < grid[i].length && dj >= 0) {
                    if (grid[di][dj] == -1 || grid[di][dj] > grid[i][j] + 1) {
                        if (grid[di][dj] == -1) {
                            goodOranges--;
                        }
                        grid[di][dj] = grid[i][j] + 1;
                        queue.add(Pair.with(di, dj));
                        maxMinutes = Math.max(maxMinutes, grid[di][dj]);
                    }
                }
            }
        }
        return goodOranges > 0 ? -1 :maxMinutes;
    }

}
