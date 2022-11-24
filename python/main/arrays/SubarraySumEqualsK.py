from typing import List


class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        cache = {0: 1}
        currentSum = 0
        count = 0
        for n in nums:
            currentSum += n
            if currentSum - k in cache:
                count += cache[currentSum - k]
            if currentSum not in cache:
                cache[currentSum] = 0
            cache[currentSum] = cache[currentSum] + 1
        return count


if __name__ == "__main__":
    solution = Solution()
    isPossible = solution.subarraySum([1, 1, 1], 2)
    print(isPossible)
