from typing import List

from main.heap.heaps import PriorityQueue
from main.lambdas.comparators import reverseOrder, naturalOrder


class Solution:
    def minCost(self, colors: str, neededTime: List[int]) -> int:

        def sumMinusMax(start, end):
            maxElement = neededTime[start]
            SUM = neededTime[start]
            for k in range(start + 1, end):
                maxElement = max(neededTime[k], maxElement)
                SUM += neededTime[k]
            return SUM - maxElement

        j = 0
        timeSum = 0
        for i in range(1, len(colors)):
            if colors[i] != colors[j]:
                if i - j > 1:
                    timeSum += sumMinusMax(j, i)
                j = i
        if len(colors) - j > 1:
            timeSum += sumMinusMax(j, len(colors))
        return timeSum


if __name__ == "__main__":
    solution = Solution()
    output = solution.minCost("aabaa", [1, 2, 3, 4, 1])
    print(output)
