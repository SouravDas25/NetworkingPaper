CACHE = [0] * 45
CACHE[1] = 1
CACHE[2] = 2


class Solution:

    def fillCache(self):
        for i in range(3, 45):
            CACHE[i] = CACHE[i - 1] + CACHE[i - 2]

    def climbStairs(self, n: int) -> int:
        if CACHE[-1] == 0:
            self.fillCache()
        return CACHE[n]


if __name__ == "__main__":
    solution = Solution()
    output = solution.climbStairs(3)
    print(output)
