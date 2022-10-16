from typing import List

import numpy as np


class Solution:

    def distanceMatrix(self, n: int, edges: List[List[int]]):
        distance = [[float("inf")] * n for _ in range(n)]
        for i in range(n):
            distance[i][i] = 0

        for s, d, w in edges:
            distance[s][d] = w

        for i in range(n):
            for j in range(n):
                for k in range(n):
                    if i != k and j != k:
                        distance[i][j] = min(distance[i][j], distance[i][k] + distance[k][j])
        # print()

        return distance


if __name__ == "__main__":
    solution = Solution()
    output = solution.distanceMatrix(5, [[1, 0, 2], [2, 1, 10], [0, 2, 4], [0, 3, 5], [3, 4, 3]])
    print(np.matrix(output))
