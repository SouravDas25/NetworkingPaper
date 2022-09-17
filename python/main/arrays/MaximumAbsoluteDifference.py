from typing import List


# https://www.geeksforgeeks.org/maximum-absolute-difference-value-index-sums/
class Solution:
    # @param A : list of integers
    # @return an integer
    def maxArr(self, nums: List[int]):
        # max and min variables as described
        # in algorithm.
        max1 = float("-inf")
        min1 = float("inf")
        max2 = float("-inf")
        min2 = float("inf")

        for i in range(len(nums)):
            # Updating max and min variables
            # as described in algorithm.
            max1 = max(max1, nums[i] + i)
            min1 = min(min1, nums[i] + i)
            max2 = max(max2, nums[i] - i)
            min2 = min(min2, nums[i] - i)

        # Calculating maximum absolute difference.
        return max(max1 - min1, max2 - min2)


if __name__ == "__main__":
    s = Solution()
    isPossible = s.maxArr([-70, -64, -6, -56, 64, 61, -57, 16, 48, -98])
    print(isPossible)
