from typing import List

import numpy as np


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [[float("inf")] * (amount + 1) for _ in range(len(coins) + 1)]
        dp[0][0] = 0
        for i in range(1, len(coins) + 1):
            coin = coins[i - 1]
            for target in range(amount + 1):
                if target < coin:
                    dp[i][target] = dp[i - 1][target]
                else:
                    dp[i][target] = min(dp[i - 1][target], dp[i][target - coin] + 1)

        print(np.matrix(dp))
        if dp[len(coins)][amount] != float("inf"):
            coinsUsed = []
            target = amount
            i = len(coins)
            while len(coinsUsed) < dp[len(coins)][amount]:
                if dp[i][target] == dp[i - 1][target]:
                    i -= 1
                    continue
                coinsUsed.append(coins[i-1])
                target -= coins[i-1]
            print(coinsUsed)
        return dp[len(coins)][amount]
        pass


if __name__ == "__main__":
    solution = Solution()
    output = solution.coinChange([1, 2, 5], 11)
    print(output)
