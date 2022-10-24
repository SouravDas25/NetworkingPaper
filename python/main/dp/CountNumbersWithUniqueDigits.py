CACHE = [0] * 10
CACHE[0] = 1
CACHE[1] = 10
LAST_DIGIT = 1


class Solution:
    def countNumbersWithUniqueDigits(self, N: int) -> int:
        global LAST_DIGIT
        for n in range(LAST_DIGIT + 1, N + 1):
            ans = 9
            start = 9
            for i in range(n - 1):
                ans *= start
                start -= 1
            ans += CACHE[n - 1]
            CACHE[n] = ans

        LAST_DIGIT = max(LAST_DIGIT, N)

        return CACHE[N]


if __name__ == "__main__":
    solution = Solution()
    output = solution.countNumbersWithUniqueDigits(3)
    print(output)  # 739
