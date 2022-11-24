from collections import deque
from typing import List

MOVEMENTS = [(1, 0), (0, 1), (-1, 0), (0, -1)]


class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        queue = deque()
        good_apples_count = 0
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] == 1:
                    grid[i][j] = -1
                    good_apples_count += 1
                elif grid[i][j] == 0:
                    grid[i][j] = -3
                elif grid[i][j] == 2:
                    grid[i][j] = 0
                    queue.append((i, j))

        maxTime = 0

        while len(queue) > 0:
            size = len(queue)
            for _ in range(size):
                i, j = queue.popleft()
                for di, dj in MOVEMENTS:
                    ni = i + di
                    nj = j + dj
                    if 0 <= ni < len(grid) and 0 <= nj < len(grid[ni]):
                        if grid[ni][nj] == -1:
                            grid[ni][nj] = grid[i][j] + 1
                            queue.append((ni, nj))
                            good_apples_count -= 1
                            maxTime = max(maxTime, grid[ni][nj])
        if good_apples_count > 0:
            return -1
        return maxTime

        pass


if __name__ == "__main__":
    solution = Solution()
    output = solution.orangesRotting([[2, 1, 1], [1, 1, 0], [0, 1, 1]])
    print(output)
