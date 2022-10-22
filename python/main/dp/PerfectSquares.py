CACHE = list(range(10001))
LAST_COMPUTED = 1


class Solution:
    def numSquares(self, N: int) -> int:
        global LAST_COMPUTED
        for n in range(LAST_COMPUTED + 1, N + 1):
            i = 1
            while i * i <= n:
                CACHE[n] = min(CACHE[n - i * i] + 1, CACHE[n])
                i += 1
        LAST_COMPUTED = max(N, LAST_COMPUTED)
        return CACHE[N]


if __name__ == "__main__":
    solution = Solution()
    output = solution.numSquares(12)
    print(output)
