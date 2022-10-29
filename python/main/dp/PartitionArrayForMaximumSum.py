from typing import List


class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        n = len(arr)
        dp = [0] * (n + 1)

        for i in range(len(arr) - 1, -1, -1):
            maxElement = arr[i]
            for j in range(i, min(i + k, len(arr))):
                maxElement = max(maxElement, arr[j])
                cost = (j - i + 1) * maxElement + dp[j + 1]
                dp[i] = max(dp[i], cost)
        print(dp)
        return dp[0]


if __name__ == "__main__":
    solution = Solution()
    output = solution.maxSumAfterPartitioning([1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3], 4)
    print(output)
