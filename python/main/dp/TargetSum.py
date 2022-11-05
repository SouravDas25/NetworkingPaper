from typing import List


class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        tot = sum(nums) + target
        if abs(target) > sum(nums) or tot % 2 != 0: return 0
        s1 = int((sum(nums) + target) / 2)
        dp = [[1 for i in range(s1 + 1)] for j in range(len(nums) + 1)]
        for i in range(1, s1 + 1):
            dp[0][i] = 0
        for i in range(1, len(nums) + 1):
            for j in range(0, s1 + 1):
                if nums[i - 1] > j:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j]
        return dp[-1][-1]


if __name__ == "__main__":
    solution = Solution()
    output = solution.findTargetSumWays([1, 1, 1, 1, 1], 3)
    print(output)
