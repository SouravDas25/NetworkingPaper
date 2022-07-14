package com.github.algo.backtracking;

import java.util.*;
import java.util.stream.Collectors;

public class NQueens {

    private void backtracking(int r, char[][] board, List<List<String>> output,
                              Set<Integer> columns, Set<Integer> negDia, Set<Integer> positiveDia) {
        if (r == board.length) {
            List<String> collect = Arrays.stream(board).map(String::valueOf).collect(Collectors.toList());
            output.add(collect);
        }
        for (int c = 0; c < board.length; c++) {
            int nd = r - c;
            int pd = r + c;

            if (!columns.contains(c) && !positiveDia.contains(pd) && !negDia.contains(nd)) {
                columns.add(c);
                positiveDia.add(pd);
                negDia.add(nd);
                board[r][c] = 'Q';

                backtracking(r + 1, board, output, columns, negDia, positiveDia);

                columns.remove(c);
                positiveDia.remove(pd);
                negDia.remove(nd);
                board[r][c] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        Set<Integer> columns = new HashSet<>();
        Set<Integer> negDia = new HashSet<>();
        Set<Integer> positiveDia = new HashSet<>();
        List<List<String>> output = new LinkedList<>();

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        backtracking(0, board, output, columns, negDia, positiveDia);

        return output;
    }

}
