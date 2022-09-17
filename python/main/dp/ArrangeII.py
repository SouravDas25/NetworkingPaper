# https://www.interviewbit.com/problems/arrange-ii/
import numpy as np


class Solution:

    def arrange(self, horses: str, stables: int):
        dp = [[float("inf")] * (len(horses) + 1) for _ in range(stables)]

        whc = bhc = 0
        for j in range(len(horses) - 1, -1, -1):
            if horses[j] == "W":
                whc += 1
            else:
                bhc += 1
            dp[-1][j] = whc * bhc

        for i in range(stables - 2, -1, -1):
            for j in range(len(horses) - 1, -1, -1):
                whc = bhc = 0
                for k in range(j, len(horses)):
                    if horses[k] == "W":
                        whc += 1
                    else:
                        bhc += 1
                    dp[i][j] = min(dp[i][j], whc * bhc + dp[i + 1][k + 1])

        print(np.matrix(dp))
        return dp[0][0]


if __name__ == "__main__":
    solution = Solution()
    output = solution.arrange("WWBWWWBB", 2)
    print(output)
