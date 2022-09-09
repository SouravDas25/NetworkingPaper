from collections import deque
from typing import List


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        graph = {i: [] for i in range(numCourses)}

        for a, b in prerequisites:
            graph[a].append(b)

        visited = set()
        current = set()

        def dfs(course):
            visited.add(course)
            current.add(course)
            for pq in graph[course]:
                if pq not in visited and not dfs(pq):
                    return False
                if pq in current:
                    return False
            current.remove(course)
            return True

        for i in range(numCourses):
            if not dfs(i):
                return False

        return True


if __name__ == "__main__":
    solution = Solution()
    output = solution.canFinish(2, [[0, 1]])
    print(output)
