from typing import List


class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if len(nums1) < len(nums2):
            nums1, nums2 = nums2, nums1
        n1 = len(nums1)
        n2 = len(nums2)
        totalN = n1 + n2
        lpc = (totalN + 1) // 2
        low = 0
        high = n2
        while low <= high:
            mid2 = (low + high) // 2
            ld = nums2[mid2 - 1] if mid2 - 1 >= 0 else float("-inf")
            rd = nums2[mid2] if mid2 < n2 else float("inf")

            mid1 = lpc - mid2

            ru = nums1[mid1] if mid1 < n1 else float("inf")
            lu = nums1[mid1 - 1] if mid1 - 1 >= 0 else float("-inf")
            print(mid2, mid1, lpc)
            print("======")
            print(lu, ru)
            print(ld, rd)
            print("======")
            if lu <= rd and ld <= ru:
                if totalN % 2 == 0:
                    return (max(lu, ld) + min(ru, rd)) / 2
                else:
                    return max(lu, ld)
            elif lu > ld:
                low = mid2 + 1
            else:
                high = mid2 - 1
        return 0

        pass


if __name__ == "__main__":
    solution = Solution()
    output = solution.findMedianSortedArrays([1, 2], [3, 4])
    print(output)
