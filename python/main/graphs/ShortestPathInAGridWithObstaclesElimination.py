from collections import deque
from typing import List

MOVES = [(1, 0), (0, 1), (-1, 0), (0, -1)]


class Solution:
    def shortestPath(self, grid: List[List[int]], k: int) -> int:
        queue = deque([(0, 0, 0, k)])
        visited = set()
        while len(queue) > 0:
            size = len(queue)
            for _ in range(size):
                i, j, level, re = queue.popleft()
                # print(i, j)
                visited.add((i, j, re))
                if i == len(grid) - 1 and j == len(grid[i]) - 1:
                    return level
                for di, dj in MOVES:
                    ni = i + di
                    nj = j + dj
                    if 0 <= ni < len(grid) and 0 <= nj < len(grid[ni]) and (ni, nj, re) not in visited:
                        if grid[ni][nj] == 0:
                            queue.append((ni, nj, level + 1, re))
                        elif grid[ni][nj] == 1 and re > 0:
                            queue.append((ni, nj, level + 1, re - 1))
                        if ni == len(grid) - 1 and nj == len(grid[i]) - 1:
                            return level + 1
        return -1


if __name__ == "__main__":
    solution = Solution()
    isPossible = solution.shortestPath([[0, 0, 0], [1, 1, 0], [0, 0, 0], [0, 1, 1], [0, 0, 0]], 1)
    print(isPossible)
