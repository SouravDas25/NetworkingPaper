from collections import defaultdict
from typing import List


class Solution:
    def longestSubsequence(self, arr: List[int], difference: int) -> int:
        dp = defaultdict(int)
        for num in arr:
            dp[num] = dp[num + difference] + 1
        print(dp)
        return max(dp.values())


if __name__ == "__main__":
    solution = Solution()
    output = solution.longestSubsequence([1, 2, 3, 4], 4)
    print(output)
