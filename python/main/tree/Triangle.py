from typing import List


class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        if len(triangle) < 1:
            return 0
        for i in range(len(triangle) - 2, -1, -1):
            for j in range(len(triangle[i])):
                triangle[i][j] = triangle[i][j] + min(triangle[i + 1][j], triangle[i + 1][j + 1])
            print(triangle[i])
        return triangle[0][0]


if __name__ == "__main__":
    s = Solution()
    minTotal = s.minimumTotal([[2], [3, 4], [6, 5, 7], [4, 1, 8, 3]])
    print(minTotal)
