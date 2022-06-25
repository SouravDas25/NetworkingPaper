from typing import List
from collections import deque

movements = [(1, 0), (-1, 0), (0, 1), (0, -1)]


def exist(board: List[List[str]], word: str) -> bool:
    if len(word) < 1:
        return True

    def dfs(i, j, matchIndex, board, visited):
        if matchIndex + 1 >= len(word):
            return True
        visited.add((i, j))
        print(i, j, matchIndex)
        for xi, xj in movements:
            mi = i + xi
            mj = j + xj
            if 0 <= mi < len(board) and 0 <= mj < len(board[i]) and (mi, mj) not in visited:
                if board[mi][mj] == word[matchIndex + 1]:
                    if matchIndex + 1 >= len(word):
                        return True
                    if dfs(mi, mj, matchIndex + 1, board, visited):
                        return True
        visited.remove((i, j))

    visited = set()
    for i in range(len(board)):
        for j in range(len(board[i])):
            if board[i][j] == word[0]:
                if dfs(i, j, 0, board, visited):
                    return True

    return False


board = [["A", "A", "A", "A", "A", "A"], ["A", "A", "A", "A", "A", "A"], ["A", "A", "A", "A", "A", "A"],
         ["A", "A", "A", "A", "A", "A"], ["A", "A", "A", "A", "A", "B"], ["A", "A", "A", "A", "B", "A"]]
word = "AAAAAAAAAAAAABB"
print(exist(board, word))