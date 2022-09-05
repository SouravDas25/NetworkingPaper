from typing import List


class Solution:

    def maxProfit(self, prices: List[int]) -> int:
        leftProfit = [0] * len(prices)
        rightProfit = [0] * len(prices)
        minPrice = prices[0]
        maxPrice = prices[-1]
        for i in range(1, len(prices)):
            leftProfit[i] = max(prices[i] - minPrice, leftProfit[i - 1])
            if prices[i] < minPrice:
                minPrice = prices[i]
            ifb = len(prices) - i - 1
            rightProfit[ifb] = max(maxPrice - prices[ifb], rightProfit[ifb + 1])
            if prices[ifb] > maxPrice:
                maxPrice = prices[ifb]
        print(leftProfit)
        print(rightProfit)
        maxProfit = 0
        for i in range(len(rightProfit) - 1):
            maxProfit = max(maxProfit, rightProfit[i] + leftProfit[i])
        return maxProfit


if __name__ == "__main__":
    sol = Solution()
    output = sol.maxProfit([2, 1, 2, 0, 1])
    print(output)
