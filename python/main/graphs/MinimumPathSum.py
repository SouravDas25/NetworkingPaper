import heapq
from collections import deque
from typing import List


class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:

        minHeap = []
        heapq.heappush(minHeap, (grid[0][0], 0, 0))

        visited = set()

        while len(minHeap) > 0:
            cost, x, y = heapq.heappop(minHeap)
            if x == len(grid) - 1 and y == len(grid[0]) - 1:
                return cost

            for dx, dy in [(1, 0), (0, 1)]:
                nx, ny = x + dx, y + dy
                if 0 <= nx < len(grid) and 0 <= ny < len(grid[0]) and (nx, ny) not in visited:
                    newCost = grid[nx][ny] + cost
                    heapq.heappush(minHeap, (newCost, nx, ny))
                    visited.add((nx, ny))

        return -1

    def minPathSum2(self, grid: List[List[int]]) -> int:

        def get(i, j):
            if 0 <= i < len(grid) and 0 <= j < len(grid[0]):
                return grid[i][j]
            else:
                return 900000

        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if i == 0 and j == 0:
                    continue
                grid[i][j] = min(get(i - 1, j), get(i, j - 1)) + grid[i][j]
                pass

        return grid[-1][-1]

        pass


if __name__ == '__main__':
    s = Solution()
    grid = [
        [0, 7, 7, 8, 1, 2, 4, 3, 0, 0, 5, 9, 8, 3, 6, 5, 1, 0],
        [2, 1, 1, 0, 8, 1, 3, 3, 9, 9, 5, 8, 7, 5, 7, 5, 5, 8],
        [9, 2, 3, 1, 2, 8, 1, 2, 3, 7, 9, 7, 9, 3, 0, 0, 3, 8],
        [3, 9, 3, 4, 8, 1, 2, 6, 8, 9, 3, 4, 9, 4, 8, 3, 6, 2],
        [3, 7, 4, 7, 6, 5, 6, 5, 8, 6, 7, 3, 6, 2, 2, 9, 9, 3],
        [2, 3, 1, 1, 5, 4, 7, 4, 0, 7, 7, 6, 9, 1, 5, 5, 0, 3],
        [0, 8, 8, 8, 4, 7, 1, 0, 2, 6, 1, 1, 1, 6, 4, 2, 7, 9],
        [8, 6, 6, 8, 3, 3, 5, 4, 6, 2, 9, 8, 6, 9, 6, 6, 9, 2],
        [6, 2, 2, 8, 0, 6, 1, 1, 4, 5, 3, 1, 7, 3, 9, 3, 2, 2],
        [8, 9, 8, 5, 3, 7, 5, 9, 8, 2, 8, 7, 4, 4, 1, 9, 2, 2],
        [7, 3, 3, 1, 0, 9, 4, 7, 2, 3, 2, 6, 7, 1, 7, 7, 8, 1],
        [4, 3, 2, 2, 7, 0, 1, 4, 4, 4, 3, 8, 6, 2, 1, 2, 5, 4],
        [1, 9, 3, 5, 4, 6, 4, 3, 7, 1, 0, 7, 2, 4, 0, 7, 8, 0],
        [7, 1, 4, 2, 5, 9, 0, 4, 1, 4, 6, 6, 8, 9, 7, 1, 4, 3],
        [9, 8, 6, 8, 2, 6, 5, 6, 2, 8, 3, 2, 8, 1, 5, 4, 5, 2],
        [3, 7, 8, 6, 3, 4, 2, 3, 5, 1, 7, 2, 4, 6, 0, 2, 5, 4],
        [8, 2, 1, 2, 2, 6, 6, 0, 7, 3, 6, 4, 5, 9, 4, 4, 5, 7]
    ]
    print(s.minPathSum2(grid))
