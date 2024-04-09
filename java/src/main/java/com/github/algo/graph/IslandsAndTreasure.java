package com.github.algo.graph;

import org.checkerframework.checker.units.qual.C;

import java.util.Deque;
import java.util.LinkedList;


public class IslandsAndTreasure {
    record Coordinate(int x, int y) {
    }

    Coordinate[] movements = new Coordinate[]{
            new Coordinate(-1, 0),
            new Coordinate(1, 0),
            new Coordinate(0, -1),
            new Coordinate(0, 1),
    };

    public void islandsAndTreasure(int[][] grid) {
        Deque<Coordinate> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    queue.addLast(new Coordinate(i, j));
                }
            }
        }
        while (!queue.isEmpty()) {
            Coordinate pos = queue.removeFirst();
            for (Coordinate move : movements) {
                int dx = move.x + pos.x;
                int dy = move.y + pos.y;
                if (dx >= 0 && dx < grid.length && dy >= 0 && dy < grid[dx].length) {
                    if (grid[dx][dy] != -1 && grid[dx][dy] > grid[pos.x][pos.y] + 1) {
                        grid[dx][dy] = grid[pos.x][pos.y] + 1;
                        queue.addLast(new Coordinate(dx, dy));
                    }
                }
            }
        }
    }
}
