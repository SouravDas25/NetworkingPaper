# https://www.interviewbit.com/problems/arrange-ii/

class Solution:

    def arrange(self, horses: str, k: int):

        def recursion(i, current, k):
            if k <= 0:
                # print(i, current)
                if i == len(horses):
                    return current
                return float("inf")
            whc = bhc = 0
            minSum = float("inf")
            for j in range(i, len(horses)):
                if horses[j] == "W":
                    whc += 1
                else:
                    bhc += 1
                s = recursion(j + 1, current + whc * bhc, k - 1)
                minSum = min(minSum, s)
            return minSum

        minc = recursion(0, 0, k)
        return -1 if minc == float("inf") else minc
        pass


if __name__ == "__main__":
    solution = Solution()
    output = solution.arrange("WWWB", 1)
    print(output)
