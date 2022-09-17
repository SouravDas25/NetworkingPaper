import numpy as np
import pandas


class Solution:
    def isPalindrome(self, s, begin, end):
        return s[begin:end + 1] == s[begin:end + 1][::-1]

    def minCut(self, s: str) -> int:
        dp = [float("inf")] * (len(s) + 1)
        dp[-1] = -1
        for i in range(len(s) - 1, -1, -1):
            for j in range(len(s) - 1, i - 1, -1):
                if self.isPalindrome(s, i, j):
                    dp[i] = min(dp[i], dp[j + 1] + 1)

        print(np.matrix(dp))
        return dp[0]


if __name__ == "__main__":
    solution = Solution()
    output = solution.minCut("aab")
    print(output)
