from collections import deque

CACHE = deque([1, 1, 2, 5])


class Solution:

    def numTrees(self, n: int) -> int:
        if n < len(CACHE):
            return CACHE[n]

        for i in range(len(CACHE), n + 1):
            dpi = 0
            for j in range(1, i + 1):
                dpi += CACHE[j - 1] * CACHE[i - j]
            CACHE.append(dpi)
        return CACHE[n]


if __name__ == "__main__":
    solution = Solution()
    output = solution.numTrees(4)
    print(output)
