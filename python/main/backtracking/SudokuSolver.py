from typing import List, Set


class Solution:

    def toBox(self, i, j) -> int:
        a = i // 3
        b = j // 3
        return a * 3 + b

    def nextPosition(self, i, j):
        if j + 1 < 9:
            return i, j + 1
        else:
            return i + 1, 0

    def dfs(self, i: int, j: int, board: List[List[str]], count: int, rows: List[Set[str]], cols: List[Set[str]],
            boxes: List[Set[str]]):
        # print(i, j, count, np.matrix(board))

        if count < 1:
            return True
        if i >= 9 or j >= 9:
            return False

        while i < 9 and j < 9 and board[i][j] != ".":
            i, j = self.nextPosition(i, j)
        # if

        for n in range(1, 10):
            n = str(n)
            if n not in rows[i] and n not in cols[j] and n not in boxes[self.toBox(i, j)]:
                board[i][j] = n
                rows[i].add(n)
                cols[j].add(n)
                boxes[self.toBox(i, j)].add(n)
                ni, nj = self.nextPosition(i, j)
                if self.dfs(ni, nj, board, count - 1, rows, cols, boxes):
                    return True
                rows[i].remove(n)
                cols[j].remove(n)
                boxes[self.toBox(i, j)].remove(n)
                board[i][j] = "."
        return False

    def solveSudoku(self, board: List[List[str]]):
        """
        Do not return anything, modify board in-place instead.
        """
        rows = [set() for _ in range(9)]
        cols = [set() for _ in range(9)]
        boxes = [set() for _ in range(9)]
        count = 0
        for i in range(9):
            for j in range(9):
                if board[i][j] != ".":
                    rows[i].add(board[i][j])
                    cols[j].add(board[i][j])
                    boxes[self.toBox(i, j)].add(board[i][j])
                else:
                    count += 1

        self.dfs(0, 0, board, count, rows, cols, boxes)


if __name__ == "__main__":
    import numpy as np

    board = [["5", "3", ".", ".", "7", ".", ".", ".", "."],
             ["6", ".", ".", "1", "9", "5", ".", ".", "."],
             [".", "9", "8", ".", ".", ".", ".", "6", "."],
             ["8", ".", ".", ".", "6", ".", ".", ".", "3"],
             ["4", ".", ".", "8", ".", "3", ".", ".", "1"],
             ["7", ".", ".", ".", "2", ".", ".", ".", "6"],
             [".", "6", ".", ".", ".", ".", "2", "8", "."],
             [".", ".", ".", "4", "1", "9", ".", ".", "5"],
             [".", ".", ".", ".", "8", ".", ".", "7", "9"]]
    s = Solution()
    s.solveSudoku(board)
    print(np.matrix(board))
