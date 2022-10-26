from collections import Counter
from typing import List


class Solution:

    def deleteAndEarn(self, nums: List[int]) -> int:
        freq = Counter(nums)
        dp1 = dp2 = 0
        for i in range(1, max(freq.keys()) + 1):
            dp = max(dp1, dp2 + i * freq[i])
            dp2 = dp1
            dp1 = dp
        return max(dp1, dp2)


if __name__ == "__main__":
    solution = Solution()
    output = solution.deleteAndEarn([3, 1])
    print(output)
