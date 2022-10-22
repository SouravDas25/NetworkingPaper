from typing import List


class Solution:
    def rob(self, nums: List[int]) -> int:
        dp1 = dp2 = 0
        for i in range(len(nums)):
            dp = max(nums[i] + dp2, dp1)
            dp2, dp1 = dp1, dp

        return max(dp2, dp1)


if __name__ == "__main__":
    s = Solution()
    isPossible = s.rob([2, 7, 9, 3, 1])
    print(isPossible)
