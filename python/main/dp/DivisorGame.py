import math

CACHE = [False] * 1001
LAST_COMPUTED = 3
CACHE[2] = True


class Solution:
    def divisorGame(self, N: int) -> bool:
        global LAST_COMPUTED
        for n in range(LAST_COMPUTED + 1, N + 1):
            if n % 2 == 0 and not CACHE[n - 2]:
                CACHE[n] = True
                continue
            for i in range(3, int(math.sqrt(n)) + 2, 2):
                if n % i == 0:
                    if not CACHE[n - i]:
                        CACHE[n] = True
                        continue
            if not CACHE[n - 1]:
                CACHE[n] = True
        LAST_COMPUTED = N
        return CACHE[N]
        pass


if __name__ == "__main__":
    solution = Solution()
    output = solution.divisorGame(9)
    print(output)
