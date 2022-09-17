from typing import List


class Solution:
    def findUnsortedSubarray(self, nums: List[int]) -> int:
        nums = list(sorted(map(lambda x: tuple(reversed(x)), enumerate(nums))))
        left = None
        for i in range(len(nums)):
            if i != nums[i][1]:
                left = i
                break
        right = None
        for i in range(len(nums) - 1, -1, -1):
            if i != nums[i][1]:
                right = i
                break
        print(nums, left, right)
        if left is not None and right is not None:
            return right - left + 1
        return 0


if __name__ == "__main__":
    s = Solution()
    isPossible = s.findUnsortedSubarray([2,1])
    print(isPossible)
