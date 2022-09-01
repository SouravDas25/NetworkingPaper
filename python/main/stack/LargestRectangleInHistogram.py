from typing import List


# https://leetcode.com/problems/largest-rectangle-in-histogram/
class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        stack = []
        maxArea = 0
        for i in range(len(heights)):
            height = heights[i]
            idx = i
            while len(stack) > 0 and height < stack[-1][0]:
                oldHeight, index = stack.pop()
                maxArea = max(maxArea, oldHeight * (i - index))
                idx = index
            stack.append((height, idx))
        while len(stack) > 0:
            oldHeight, index = stack.pop()
            maxArea = max(maxArea, oldHeight * abs(len(heights) - index))
        return maxArea


if __name__ == "__main__":
    solution = Solution()
    area = solution.largestRectangleArea([2, 1, 5, 6, 2, 3])
    print(area)
