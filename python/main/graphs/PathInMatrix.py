from collections import deque
from typing import List

MOVEMENT = [(1, 0), (-1, 0), (0, 1), (0, -1)]


class Solution:
    # @param A : list of list of integers
    # @return an integer

    def checkPath(self, matrix: List[List[int]]):
        queue = deque([])
        for i in range(len(matrix)):
            for j in range(len(matrix[i])):
                if matrix[i][j] == 2:
                    queue.append((i, j))

        while len(queue) > 0:
            i, j = queue.popleft()
            for di, dj in MOVEMENT:
                ni = i + di
                nj = j + dj
                if 0 <= ni < len(matrix) and 0 <= nj < len(matrix[0]):
                    if matrix[ni][nj] == 3:
                        matrix[ni][nj] = 2
                        queue.append((ni, nj))
                    if matrix[ni][nj] == 1:
                        return 1
        return 0


if __name__ == "__main__":
    s = Solution()
    isPossible = s.checkPath([[1, 3], [3, 2]])
    print(isPossible)
