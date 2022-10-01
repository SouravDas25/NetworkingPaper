from typing import List


class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [0] * n
        ans = 0
        for i in range(2, n):
            if nums[i-1] - nums[i-2] == nums[i] - nums[i-1]:
                dp[i] = dp[i-1] + 1
            ans += dp[i]
        return ans
        pass


if __name__ == "__main__":
    solution = Solution()
    output = solution.numberOfArithmeticSlices([1, 2, 3, 4, 5, 6, -1, 0, 1, 2, 3, 4])
    print(output)
