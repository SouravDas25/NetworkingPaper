from typing import List


class Solution:
    def maxPerformance(self, n: int, speed: List[int], efficiency: List[int], k: int) -> int:

        minHeap = list(zip(speed, efficiency))

        pass


if __name__ == "__main__":
    solution = Solution()
    output = solution.maxPerformance(3, [2, 8, 2], [2, 7, 1], 2)
    print(output)
