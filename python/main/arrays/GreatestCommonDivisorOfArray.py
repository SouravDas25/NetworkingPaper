import math
from typing import List


class Solution:

    def gcd(self, a, b):
        print(a, b)
        if a == 0:
            return b
        if b == 0:
            return a

        if a == b:
            return a

        if a > b:
            return self.gcd(a % b, b)
        return self.gcd(a, b % a)

    def findGCD(self, nums: List[int]) -> int:
        return self.gcd(max(nums), min(nums))


if __name__ == "__main__":
    s = Solution()
    isPossible = s.findGCD([11, 14, 7])
    print(isPossible)
