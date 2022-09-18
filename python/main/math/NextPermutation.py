from typing import List


class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        changePoint = None
        for i in range(len(nums) - 1, 0, -1):
            if nums[i - 1] < nums[i]:
                changePoint = i - 1
                break
        if changePoint is None:
            nums.sort()
            return nums
        else:
            swapPoint = changePoint + 1
            for i in range(changePoint + 2, len(nums)):
                if nums[changePoint] < nums[i] < nums[swapPoint]:
                    swapPoint = i
            nums[changePoint], nums[swapPoint] = nums[swapPoint], nums[changePoint]
            nums[changePoint + 1:].sort()
            return nums
        pass


if __name__ == "__main__":
    solution = Solution()
    output = solution.nextPermutation(list("19"))
    print(output)
