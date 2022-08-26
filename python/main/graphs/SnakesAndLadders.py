from collections import deque
from typing import List


class Solution:

    def snakesAndLadders(self, board: List[List[int]]) -> int:
        nb = {}
        count = 1
        flag = True
        for i in range(len(board) - 1, -1, -1):
            if flag:
                for j in range(len(board[i])):
                    nb[count] = count if board[i][j] == -1 else board[i][j]
                    count += 1
            else:
                for j in range(len(board[i]) - 1, -1, -1):
                    nb[count] = count if board[i][j] == -1 else board[i][j]
                    count += 1
            flag = not flag
        board = nb
        print(board)
        cache = {1: 0}
        queue = deque([(0, 1)])
        MM = float("inf")
        while len(queue) > 0:
            moves, position = queue.popleft()
            for i in range(1, 7):
                if position + i not in board:
                    continue
                nextPosition = board[position + i]
                if nextPosition not in cache or cache[nextPosition] > moves + 1:
                    queue.append((moves + 1, nextPosition))
                    cache[nextPosition] = moves + 1
                if nextPosition == len(board):
                    MM = min(MM, moves + 1)
        return -1 if MM == float("inf") else MM


if __name__ == "__main__":
    s = Solution()
    minMoves = s.snakesAndLadders(
        [[-1, 231, -1, 173, -1, -1, 46, 39, 30, -1, -1, -1, -1, -1, -1, 172, -1],
         [287, -1, -1, -1, -1, -1, -1, -1, -1, 66, -1, 205, -1, 28, -1, -1, -1],
         [141, -1, -1, -1, 43, -1, -1, 200, -1, -1, -1, 147, -1, 224, -1, -1, -1],
         [215, 89, 231, 80, 12, 214, 25, -1, -1, -1, -1, -1, 281, -1, 133, 237, -1],
         [-1, -1, -1, -1, 55, -1, 177, 172, -1, -1, -1, -1, -1, 284, 229, -1, -1],
         [-1, 45, 112, -1, -1, 33, -1, -1, -1, -1, -1, -1, -1, -1, -1, 178, 266],
         [-1, 128, -1, -1, 191, 219, -1, 140, -1, -1, -1, -1, -1, -1, 141, -1, -1],
         [-1, 105, -1, -1, -1, -1, -1, 173, -1, -1, -1, -1, -1, -1, -1, 181, -1],
         [-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1],
         [-1, -1, -1, 78, 219, -1, 56, -1, 117, -1, -1, 88, -1, 44, 103, -1, 243],
         [-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1],
         [-1, -1, -1, -1, 233, -1, 218, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1],
         [201, 136, -1, -1, -1, -1, -1, -1, -1, -1, -1, 184, 68, -1, -1, 107, -1],
         [-1, -1, -1, -1, -1, 185, -1, -1, -1, -1, 52, -1, -1, -1, -1, -1, -1],
         [-1, -1, -1, -1, 52, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1],
         [-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1],
         [-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1]]
    )
    print(minMoves)
