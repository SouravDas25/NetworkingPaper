from collections import deque
from typing import List, Dict, Tuple


class Solution:

    def solve(self, board: Dict[int, int]):
        visited = set()
        queue = deque([(0, 1)])
        while len(queue) > 0:
            size = len(queue)
            for _ in range(size):
                moves, position = queue.popleft()
                if position == len(board):
                    return moves
                for i in range(1, 7):
                    if position + i not in board:
                        continue
                    nextPosition = board[position + i]
                    if nextPosition not in visited:
                        queue.append((moves + 1, nextPosition))
                        visited.add(nextPosition)
                    if nextPosition == len(board):
                        return moves + 1
        return -1

    def buildBoard(self, boardSize: int, ladders: List[Tuple[int, int]], snakes: List[Tuple[int, int]]):
        board = {i: i for i in range(1, boardSize + 1)}
        for ladder in ladders:
            board[ladder[0]] = ladder[1]
        for snakes in snakes:
            board[snakes[0]] = snakes[1]
        return board

    def buildBoard2(self, inputBoard: List[List[int]]):
        board = {}
        count = 1
        flag = True
        for i in range(len(inputBoard) - 1, -1, -1):
            if flag:
                for j in range(len(inputBoard[i])):
                    board[count] = count if inputBoard[i][j] == -1 else inputBoard[i][j]
                    count += 1
            else:
                for j in range(len(inputBoard[i]) - 1, -1, -1):
                    board[count] = count if inputBoard[i][j] == -1 else inputBoard[i][j]
                    count += 1
            flag = not flag
        return board

    def snakeLadder(self, A, B):
        board = self.buildBoard(100, A, B)
        return self.solve(board)

    def snakesAndLadders(self, board: List[List[int]]) -> int:
        board = self.buildBoard2(board)
        return self.solve(board)
        # print(board)


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
    ladders = [[32, 62],
               [42, 68],
               [12, 98]]
    snakes = [[95, 13],
              [97, 25],
              [93, 37],
              [79, 27],
              [75, 19],
              [49, 47],
              [67, 17]]
    minMoves = s.snakeLadder(ladders, snakes)
    print(minMoves)
