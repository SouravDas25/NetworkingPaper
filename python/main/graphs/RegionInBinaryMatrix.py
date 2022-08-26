from collections import deque

MOVEMENTS = [(1, 0), (-1, 0), (0, 1), (0, -1), (-1, -1), (1, -1), (1, 1), (-1, 1)]


class Solution:
    # @param A : list of list of integers
    # @return an integer

    def grabRegion(self, pi, pj, matrix):
        queue = deque()
        queue.append((pi, pj))
        count = 1
        while len(queue) > 0:
            i, j = queue.popleft()
            for di, dj in MOVEMENTS:
                ni = i + di
                nj = j + dj
                if 0 <= ni < len(matrix) and 0 <= nj < len(matrix[ni]):
                    if matrix[ni][nj] == 1:
                        matrix[ni][nj] = matrix[i][j]
                        queue.append((ni, nj))
                        count += 1
        return count

    def solve(self, matrix):
        maxCount = 0
        region = 2
        for i in range(len(matrix)):
            for j in range(len(matrix[i])):
                if matrix[i][j] == 1:
                    matrix[i][j] = region
                    count = self.grabRegion(i, j, matrix)
                    maxCount = max(maxCount, count)
                    region += 1
        return maxCount


if __name__ == "__main__":
    s = Solution()
    size = s.solve([[0, 0, 1, 1, 0],
                    [1, 0, 1, 1, 0],
                    [0, 1, 0, 0, 0],
                    [0, 0, 0, 0, 1],
                    ])
    print(size)
