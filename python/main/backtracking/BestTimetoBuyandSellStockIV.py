from typing import List


class Solution:

    def maxProfit(self, k: int, prices: List[int]) -> int:

        cache = {}

        def rec(i, haveBrought, noOfSells):
            if i >= len(prices) or noOfSells >= k:
                return 0
            if (i, haveBrought, noOfSells) in cache:
                return cache[(i, haveBrought, noOfSells)]
            pb = ps = ph = pnb = 0
            if haveBrought:
                ps = prices[i] + rec(i + 1, False, noOfSells + 1)
                ph = rec(i + 1, True, noOfSells)
            else:
                pb = -prices[i] + rec(i + 1, True, noOfSells)
                pnb = rec(i + 1, False, noOfSells)

            cache[(i, haveBrought, noOfSells)] = max(ps, ph, pb, pnb)
            return cache[(i, haveBrought, noOfSells)]

        return rec(0, False, 0)


if __name__ == "__main__":
    sol = Solution()
    output = sol.maxProfit(2, [3, 2, 6, 5, 0, 3])
    print(output)
