import numpy as np
import pandas


class Solution:
    def minCut(self, s: str) -> int:
        dp = [[0] * len(s) for _ in range(len(s))]

        for i in range(len(s) - 1, -1, -1):
            for j in range(i + 1, len(s)):
                if s[i] == s[j] and dp[i + 1][j - 1] == 0:
                    dp[i][j] = 0
                else:
                    dp[i][j] = min(dp[i][j - 1], dp[i + 1][j]) + 1

        print(pandas.DataFrame(dp, columns=list(s), index=list(s)))
        return dp[0][len(s) - 1]


if __name__ == "__main__":
    solution = Solution()
    output = solution.minCut("cabababcbc")
    print(output)
