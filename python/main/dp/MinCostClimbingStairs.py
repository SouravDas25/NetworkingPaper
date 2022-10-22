from typing import List


class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        dp1, dp2, dp = 0, 0, 0
        for sc in cost:
            dp = min(dp1 + sc, dp2 + sc)
            dp2 = dp1
            dp1 = dp
        return min(dp2, dp1)
        pass


if __name__ == "__main__":
    solution = Solution()
    output = solution.minCostClimbingStairs([10, 15, 20])
    print(output)
