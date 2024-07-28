from typing import List

"""
[2, 4, 1]



"""


class Solution:

    def maxProfit(self, prices: List[int]) -> int:

        def rec(i, canBuy):
            if i == len(prices):
                return 0

            if canBuy:
                pb = -prices[i] + rec(i + 1, False)
                ph = rec(i + 1, True)
                return max(pb, ph)
            else:
                ps = prices[i] + rec(i + 1, True)
                ph = rec(i + 1, False)
                return max(ps, ph)

            pass

        return rec(0, True)

        pass


if __name__ == "__main__":
    sol = Solution()
    output = sol.maxProfit([2, 1, 2, 0, 1])
    print(output)
