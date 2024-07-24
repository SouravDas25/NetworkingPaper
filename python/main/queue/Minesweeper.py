from collections import deque
from typing import List

import click
import numpy as np

MOVEMENT = [(0, 1), (1, 0), (-1, 0), (0, -1), (1, -1), (-1, 1), (1, 1), (-1, -1)]


class Solution:
    def updateBoard(self, board: List[List[str]], click: List[int]) -> List[List[str]]:
        stack = deque([click])
        while len(stack) > 0:
            x, y = stack.pop()
            if board[x][y] == 'M':
                board[x][y] = 'X'
                break

            if board[x][y] == 'E':
                mineCount = 0
                ts = []
                for dx, dy in MOVEMENT:
                    nx, ny = x + dx, y + dy
                    if 0 <= nx < len(board) and 0 <= ny < len(board[nx]):
                        if board[nx][ny] == 'M':
                            mineCount += 1
                        # if board[nx][ny] == 'E':
                        #     stack.append((nx, ny))
                        ts.append((nx, ny))

                if mineCount > 0:
                    board[x][y] = str(mineCount)
                else:
                    board[x][y] = 'B'
                    stack.extend(ts)
            pass
        return board
        pass


if __name__ == '__main__':
    solution = Solution()
    board = [
        ["E", "E", "E", "E", "E"],
        ["E", "E", "M", "E", "E"],
        ["E", "E", "E", "E", "E"],
        ["E", "E", "E", "E", "E"]
    ]
    result = solution.updateBoard(board, [3, 0])
    print(np.array(board))
    [
        ["B", "1", "E", "1", "B"],
        ["B", "1", "M", "1", "B"],
        ["B", "1", "1", "1", "B"],
        ["B", "B", "B", "B", "B"]
    ]
