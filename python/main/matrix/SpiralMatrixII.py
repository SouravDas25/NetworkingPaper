from typing import List

import numpy as np

from main.matrix.SpiraIterator import SpiralIterator


class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        row = n
        col = n
        matrix = [[0] * col for _ in range(row)]
        count = 1
        itr = SpiralIterator(row, col)
        while itr.hasNext():
            row, col = itr.next()
            matrix[row][col] = count
            count += 1
        return matrix


if __name__ == "__main__":
    solution = Solution()
    mat = solution.generateMatrix(3)
    print(np.matrix(mat))
