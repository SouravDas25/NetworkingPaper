from typing import List


class Solution:
    def wiggleMaxLength(self, nums: List[int]) -> int:
        if len(nums) <= 1:
            return len(nums)
        if len(nums) <= 2:
            return 1 if nums[0] == nums[1] else 2

        dp = [0] * len(nums)
        dp[0] = 1
        pd = None
        for i in range(1, len(nums)):
            d = nums[i] - nums[i - 1]
            isNegative = d < 0
            if isNegative != pd and d != 0:
                dp[i] = dp[i - 1] + 1
                pd = isNegative
            else:
                dp[i] = dp[i - 1]
        # print(dp)
        return dp[-1]

        pass


if __name__ == "__main__":
    solution = Solution()
    output = solution.wiggleMaxLength([1, 7, 4, 0, 0, 9, 2, 5])
    print(output)
