from collections import deque
from typing import List

MOVEMENTS = [(1, 0), (-1, 0), (0, 1), (0, -1), (-1, -1), (1, -1), (1, 1), (-1, 1)]


class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        M = len(grid)
        N = len(grid[0])

        if grid[0][0] == 0 and M == 1:
            return 1
        if grid[0][0] != 0 or grid[M - 1][N - 1] != 0:
            return -1

        queue = deque([(0, 0)])
        d = 0
        visited = set()
        while len(queue) > 0:
            d += 1
            sz = len(queue)
            for _ in range(sz):
                i, j = queue.popleft()
                visited.add((i, j))
                for di, dj in MOVEMENTS:
                    ni = i + di
                    nj = j + dj
                    if 0 <= ni < M and 0 <= nj < N:
                        if grid[ni][nj] == 0 and (ni, nj) not in visited:
                            if ni == M - 1 and nj == N - 1:
                                return d + 1
                            queue.append((ni, nj))
        return -1
        pass


if __name__ == "__main__":
    s = Solution()
    isPossible = s.shortestPathBinaryMatrix([[0, 0, 0], [1, 1, 0], [1, 1, 0]])
    print(isPossible)
