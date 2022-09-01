from typing import List


# https://leetcode.com/problems/merge-sorted-array/

class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        i = m - 1
        j = n - 1
        count = m + n - 1
        while i >= 0 or j >= 0:

            if i >= 0:
                n1 = nums1[i]
            else:
                n1 = float("-inf")

            if j >= 0:
                n2 = nums2[j]
            else:
                n2 = float("-inf")

            if n1 > n2:
                nums1[count] = n1
                i -= 1
            else:
                nums1[count] = n2
                j -= 1
            count -= 1


if __name__ == "__main__":
    solution = Solution()
    op = [1, 2, 3, 0, 0, 0]
    solution.merge(op, 3, [2, 5, 6], 3)
    print(op)
