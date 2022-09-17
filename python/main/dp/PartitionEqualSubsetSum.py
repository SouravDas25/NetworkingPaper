from typing import List

import numpy


class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        target = sum(nums)
        if target % 2 == 1:
            return False
        target = target // 2
        # print(target)
        dp = [[False] * (target + 1) for _ in range(len(nums) + 1)]

        dp[0][0] = True

        # for i in range(len(nums) + 1):
        #     dp[i][0] = True

        for i in range(len(nums)):
            for amount in range(1, target + 1):
                if amount < nums[i]:
                    dp[i + 1][amount] = dp[i][amount]
                else:
                    dp[i + 1][amount] = dp[i][amount] or dp[i][amount - nums[i]]

        print(numpy.matrix(dp))
        return dp[len(nums)][target]


if __name__ == "__main__":
    solution = Solution()
    output = solution.canPartition([1, 5, 5, 11])
    print(output)
