package com.github.algo.graph;

import org.javatuples.Pair;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PacificAtlanticWaterFlow {

    static int[][] movements = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private void dfs(int i, int j, int[][] heights, Set<Pair<Integer, Integer>> visited) {
        visited.add(Pair.with(i, j));
        for (int[] move : movements) {
            int di = i + move[0], dj = j + move[1];
            if (di < heights.length && di >= 0 && dj < heights[di].length && dj >= 0) {
                if (heights[i][j] <= heights[di][dj] && !visited.contains(Pair.with(di, dj))) {
                    dfs(di, dj, heights, visited);
                }
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Set<Pair<Integer, Integer>> pacificWater = new HashSet<>();
        Set<Pair<Integer, Integer>> atlanticWater = new HashSet<>();

        for (int i = 0; i < heights.length; i++) {
            dfs(i, 0, heights, pacificWater);
        }
        for (int j = 0; j < heights[0].length; j++) {
            dfs(0, j, heights, pacificWater);
        }

        for (int i = 0; i < heights.length; i++) {
            dfs(i, heights[0].length - 1, heights, atlanticWater);
        }
        for (int j = 0; j < heights[0].length; j++) {
            dfs(heights.length - 1, j, heights, atlanticWater);
        }

        return pacificWater.stream()
                .filter(atlanticWater::contains)
                .map(pair -> Arrays.asList(pair.getValue0(), pair.getValue1()))
                .collect(Collectors.toList());
    }

}
