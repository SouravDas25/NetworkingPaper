from collections import defaultdict, deque
from typing import List


class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        graph = {i: [] for i in range(numCourses)}

        for p, q in prerequisites:
            graph[q].append(p)

        current = set()
        output = deque([])
        visited = set()

        def dfs(i):
            if i in visited:
                return True
            current.add(i)
            visited.add(i)
            for q in graph[i]:
                if q in current or not dfs(q):
                    return False
            current.remove(i)
            output.appendleft(i)
            return True

        for i in range(numCourses):
            if not dfs(i):
                return []

        return output

        pass


if __name__ == '__main__':
    solution = Solution()
    order = solution.findOrder(4, [[1, 0], [2, 0], [3, 1], [3, 2]])
    print(order)
