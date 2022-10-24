CACHE = [0] * 58
LAST_DIGIT = 2
CACHE[1] = 1
CACHE[2] = 1


class Solution:
    def integerBreak(self, N: int) -> int:
        global LAST_DIGIT
        for n in range(LAST_DIGIT + 1, N + 1):
            maxProduct = 0
            for i in range(2, min(n, 10)):
                maxProduct = max(CACHE[n - i] * i, (n - i) * i, maxProduct)
            CACHE[n] = maxProduct
        LAST_DIGIT = max(N, LAST_DIGIT)
        return CACHE[N]


if __name__ == "__main__":
    solution = Solution()
    output = solution.integerBreak(10)
    print(output)
