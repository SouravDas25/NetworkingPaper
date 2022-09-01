# https://leetcode.com/problems/edit-distance/
class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        W1_LEN = len(word1)
        W2_LEN = len(word2)
        dp = [[0] * (W1_LEN + 1) for _ in range(W2_LEN + 1)]
        for i in range(W1_LEN):
            dp[W2_LEN][i] = W1_LEN - i
        for i in range(W2_LEN):
            dp[i][W1_LEN] = W2_LEN - i
        for i in range(W2_LEN - 1, -1, -1):
            for j in range(W1_LEN - 1, -1, -1):
                if word2[i] == word1[j]:
                    dp[i][j] = dp[i + 1][j + 1]
                else:
                    dp[i][j] = min(dp[i + 1][j], dp[i + 1][j + 1], dp[i][j + 1]) + 1
        #     print(np.array(dp))
        return dp[0][0]


if __name__ == "__main__":
    solution = Solution()
    op = solution.minDistance("horse", "ros")
    print(op)
