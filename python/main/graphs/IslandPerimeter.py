from typing import List

MOVEMENTS = [(1, 0), (0, 1), (-1, 0), (0, -1)]


class Solution:
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        visited = set()

        def dfs(i, j):
            visited.add((i, j))
            perimeter = 0
            for di, dj in MOVEMENTS:
                ni = i + di
                nj = j + dj
                if 0 <= ni < len(grid) and 0 <= nj < len(grid[ni]):
                    if (ni, nj) not in visited and 1 == grid[ni][nj]:
                        perimeter += dfs(ni, nj)
                    if grid[ni][nj] != 1:
                        perimeter += 1
                else:
                    perimeter += 1
            return perimeter

        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] == 1 and (i, j) not in visited:
                    return dfs(i, j)
        return 0


if __name__ == "__main__":
    solution = Solution()
    output = solution.islandPerimeter([[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]])
    print(output)
