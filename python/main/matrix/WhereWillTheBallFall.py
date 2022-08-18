from typing import List


class Solution:
    def findBall(self, grid: List[List[int]]) -> List[int]:
        row = len(grid)
        col = len(grid[0])
        dp = [[-1] * col for i in range(row + 1)]

        dp[-1] = list(range(col))
        print(dp)

        for i in range(len(dp) - 2, -1, -1):
            for j in range(len(dp[i])):
                if grid[i][j] == 1:
                    if j + 1 < len(grid[i]) and grid[i][j + 1] == 1:
                        dp[i][j] = dp[i + 1][j + 1]
                    else:
                        dp[i][j] = -1
                else:
                    if j - 1 >= 0 and grid[i][j - 1] == -1:
                        dp[i][j] = dp[i + 1][j - 1]
                    else:
                        dp[i][j] = -1
        print(dp)
        return dp[0]


if __name__ == "__main__":
    s = Solution()
    output = s.findBall([[1, 1, 1, 1, 1, 1], [-1, -1, -1, -1, -1, -1], [1, 1, 1, 1, 1, 1], [-1, -1, -1, -1, -1, -1]])
    print(output)
