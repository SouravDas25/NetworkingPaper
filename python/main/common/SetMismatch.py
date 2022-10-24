from collections import Counter
from typing import List


class Solution:
    def findErrorNums(self, nums: List[int]) -> List[int]:
        counts = Counter(nums)
        # print(nums)
        duplicate = None
        missing = None
        for i in range(len(nums)):
            item = i + 1
            if item not in counts:
                missing = item
            else:
                if counts[item] == 2:
                    duplicate = item

            if missing is not None and duplicate is not None:
                return [duplicate, missing]
        return []


if __name__ == "__main__":
    solution = Solution()
    output = solution.findErrorNums([1, 1])
    print(output)
