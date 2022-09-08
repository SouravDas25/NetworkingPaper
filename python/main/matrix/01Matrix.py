from collections import deque
from typing import List

import numpy as np


class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        queue = deque()
        for i in range(len(mat)):
            for j in range(len(mat[i])):
                if mat[i][j] == 0:
                    queue.append((i, j))
                else:
                    mat[i][j] = -1
        movement = [(1, 0), (-1, 0), (0, 1), (0, -1)]
        while len(queue) > 0:
            i, j = queue.popleft()

            for m in movement:
                xi, xj = i + m[0], j + m[1]
                if 0 <= xi < len(mat) and 0 <= xj < len(mat[i]):
                    if mat[xi][xj] == -1:
                        mat[xi][xj] = mat[i][j] + 1
                        queue.append((xi, xj))

        return mat


if __name__ == "__main__":
    solution = Solution()
    mat = solution.updateMatrix([[0, 0, 0], [0, 1, 0], [1, 1, 1]])
    print(np.matrix(mat))
