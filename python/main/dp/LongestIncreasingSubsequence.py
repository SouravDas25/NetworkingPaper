from typing import List


class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        dp = [1] * len(nums)
        for i in range(len(nums) - 1, -1, -1):
            for j in range(i + 1, len(nums)):
                if nums[i] < nums[j]:
                    dp[i] = max(dp[i], dp[j] + 1)
        return max(dp)

    def lengthOfLIS2(self, nums: List[int]) -> int:

        def rec(i, output: List):
            if i == len(nums):
                # print(output)
                return len(output)

            res = []

            if len(output) <= 0 or output[-1] < nums[i]:
                output.append(nums[i])
                res.append(rec(i + 1, output))
                output.pop(-1)

            res.append(rec(i + 1, output))

            return max(res)

        return rec(0, [])

        pass


if __name__ == '__main__':
    s = Solution()
    print(s.lengthOfLIS2([4, 10, 4, 3, 8, 9]))
    assert s.lengthOfLIS2([10, 9, 2, 5, 3, 7, 101, 18]) == 4
    assert s.lengthOfLIS2([0, 1, 0, 3, 2, 3]) == 4
    assert s.lengthOfLIS2([7, 7, 7, 7, 7, 7, 7]) == 1
    assert s.lengthOfLIS2([4, 10, 4, 3, 8, 9]) == 3
