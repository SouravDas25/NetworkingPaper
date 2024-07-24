from typing import List

import numpy as np

MOVEMENT = [(0, 1), (1, 0), (0, -1), (-1, 0), (1, -1), (-1, 1), (1, 1), (-1, -1)]


class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        oldBoard = [[0] * len(board[_]) for _ in range(len(board))]
        for i in range(len(board)):
            for j in range(len(board[i])):
                oldBoard[i][j] = board[i][j]

        # print(np.array(oldBoard))

        for i in range(len(board)):
            for j in range(len(board[i])):
                board[i][j] = 0
                oneCount = 0
                for dx, dy in MOVEMENT:
                    nx, ny = i + dx, j + dy
                    if 0 <= nx < len(board) and 0 <= ny < len(board[0]):
                        if oldBoard[nx][ny] == 1:
                            oneCount += 1

                if oldBoard[i][j] == 1 and (oneCount == 2 or oneCount == 3):
                    board[i][j] = 1
                if oldBoard[i][j] == 0 and oneCount == 3:
                    board[i][j] = 1

                print(i, j, oneCount)

        pass


if __name__ == '__main__':
    solution = Solution()
    board = [[0,0]]
    solution.gameOfLife(board)
    print(np.array(board))
