from functools import lru_cache
from typing import List


class Solution:

    @lru_cache(None)
    def bitCount(self, n: int):
        return bin(n).count("1")

    def countBits(self, n: int) -> List[int]:
        output = []
        for i in range(n + 1):
            output.append(self.bitCount(i))
        return output


if __name__ == "__main__":
    solution = Solution()
    output = solution.countBits(5)
    print(output)
