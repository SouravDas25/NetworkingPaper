import heapq
from typing import List


class Solution:

    def sortOneDiagonal(self, i, j, matrix):
        minHeap = []
        count = 0
        while i + count < len(matrix) and j + count < len(matrix[i]):
            di = i + count
            dj = j + count
            heapq.heappush(minHeap, matrix[di][dj])
            count += 1

        count = 0
        while i + count < len(matrix) and j + count < len(matrix[i]):
            di = i + count
            dj = j + count
            matrix[di][dj] = heapq.heappop(minHeap)
            count += 1

    def diagonalSort(self, mat: List[List[int]]) -> List[List[int]]:

        if len(mat) <= 1:
            return mat

        for i in range(len(mat)):
            j = 0
            self.sortOneDiagonal(i, j, mat)

        for j in range(1, len(mat[0])):
            i = 0
            self.sortOneDiagonal(i, j, mat)

        return mat


if __name__ == "__main__":
    s = Solution()
    output = s.diagonalSort([[3, 3, 1, 1], [2, 2, 1, 2], [1, 1, 1, 2]])
    print(output)
