from typing import List

movement = [(-1, 0), (1, 0), (0, 1), (0, -1)]


class Solution:

    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        maxSize = 0

        def dfs(grid, i, j):
            count = 1
            grid[i][j] = -1
            for m in movement:
                xi, xj = i + m[0], j + m[1]
                if 0 <= xi < len(grid) and 0 <= xj < len(grid[i]):
                    if grid[xi][xj] == 1:
                        count += dfs(grid, xi, xj)
            return count

        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] == 1:
                    size = dfs(grid, i, j)
                    maxSize = max(maxSize, size)
        return maxSize


if __name__ == "__main__":
    solution = Solution()
    output = solution.maxAreaOfIsland([[0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0],
                                       [0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0], [0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0],
                                       [0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0],
                                       [0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0],
                                       [0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0]])
    print(output)
