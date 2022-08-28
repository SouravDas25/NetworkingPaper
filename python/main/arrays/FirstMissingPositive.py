import heapq
from typing import List


class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        i = 0
        while i < len(nums):
            if nums[i] > 0 and nums[i] != i + 1:
                swapWith = nums[i] - 1
                if swapWith >= len(nums) or i == swapWith or nums[swapWith] == nums[i]:
                    i += 1
                    continue
                nums[i], nums[swapWith] = nums[swapWith], nums[i]
            else:
                i += 1
        print(nums)
        for i in range(len(nums)):
            if i + 1 != nums[i]:
                return i + 1
        return len(nums) + 1


if __name__ == "__main__":
    s = Solution()
    isPossible = s.firstMissingPositive([1,1])
    print(isPossible)
