from typing import List

MOVEMENTS = [(1, 0), (0, 1), (-1, 0), (0, -1)]


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        visited = set()

        def dfs(i, j):
            visited.add((i, j))
            for di, dj in MOVEMENTS:
                ni = i + di
                nj = j + dj
                if 0 <= ni < len(grid) and 0 <= nj < len(grid[ni]):
                    if (ni, nj) not in visited and "1" == grid[ni][nj]:
                        dfs(ni, nj)

        count = 0
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] == "1" and (i, j) not in visited:
                    dfs(i, j)
                    count += 1
        return count

        pass


if __name__ == "__main__":
    solution = Solution()
    output = solution.numIslands([
        ["1", "1", "1", "1", "0"],
        ["1", "1", "0", "1", "0"],
        ["1", "1", "0", "0", "0"],
        ["0", "0", "0", "0", "1"]
    ])
    print(output)
