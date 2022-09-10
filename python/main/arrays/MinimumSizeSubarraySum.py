from typing import List


class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        if sum(nums) < target:
            return 0
        window = 0
        i = 0
        j = -1
        minLength = len(nums)
        while i < len(nums):
            window += nums[i]

            if window >= target:
                minLength = min(minLength, i - j)

            while window >= target and j < i:
                j += 1
                window -= nums[j]
                if window >= target:
                    minLength = min(minLength, i - j)
            i += 1

        while window >= target and j < i:
            j += 1
            window -= nums[j]
            if window >= target:
                minLength = min(minLength, i - j)
        return minLength


if __name__ == "__main__":
    solution = Solution()
    output = solution.minSubArrayLen(11, [1, 1, 1, 1, 1, 1, 1, 1])
    print(output)
