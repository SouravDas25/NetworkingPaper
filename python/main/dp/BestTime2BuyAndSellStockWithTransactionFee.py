from functools import lru_cache
from typing import List


class Solution:
    def maxProfit(self, prices: List[int], fee: int) -> int:

        @lru_cache(None)
        def dfs(i, previousState):
            if i >= len(prices):
                return 0
            maxProfit = 0
            if previousState == "S":
                pb = dfs(i + 1, "B") - prices[i]
                pnb = dfs(i + 1, previousState)
                maxProfit = max(maxProfit, pb, pnb)
            else:
                ps = dfs(i + 1, "S") + prices[i] - fee
                pns = dfs(i + 1, previousState)
                maxProfit = max(maxProfit, ps, pns)
            return maxProfit

        return dfs(0, "S")


if __name__ == "__main__":
    solution = Solution()
    output = solution.maxProfit([1, 3, 7, 5, 10, 3], 3)
    print(output)  # 739
