from typing import List

import numpy as np

DURATIONS = [1, 7, 30]


class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        m = max(days)
        dp = [0] * (m + 31)
        days = set(days)
        for day in range(m, 0, -1):
            if day in days:
                dp[day] = min([(costs[i] + dp[day + DURATIONS[i]]) for i in range(3)])
            else:
                dp[day] = dp[day + 1]

        # print(np.matrix(dp))
        return dp[1]


if __name__ == "__main__":
    solution = Solution()
    output = solution.mincostTickets([1, 4, 6, 7, 8, 20], [2, 7, 15])
    print(output)
