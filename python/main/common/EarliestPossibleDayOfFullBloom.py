from typing import List


class Solution:
    def earliestFullBloom(self, plantTime: List[int], growTime: List[int]) -> int:
        start = 0
        maxTime = 0
        for gt, pt in sorted(zip(growTime, plantTime), reverse=True):
            maxTime = max(maxTime, start + pt + gt)
            start += pt
        return maxTime


if __name__ == "__main__":
    solution = Solution()
    output = solution.earliestFullBloom([1, 4, 3], [2, 3, 1])
    print(output)
