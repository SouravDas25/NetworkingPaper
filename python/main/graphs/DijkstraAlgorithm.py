from collections import defaultdict
from typing import List

from main.heap.heaps import PriorityQueue
from main.lambdas import comparators


class Solution:

    def dijsktraDistance(self, source, n: int, edges: List[List[int]]):
        distance = [float("inf")] * n
        distance[source] = 0

        graph = defaultdict(list)
        for u, v, w in edges:
            graph[u].append((v, w))

        visited = set()

        queue = PriorityQueue(None)
        queue.push((0, source))
        while len(queue) > 0:
            d, u = queue.pop()
            visited.add(u)
            distance[u] = d
            for v, w in graph[u]:
                if v not in visited:
                    queue.push((d + w, v))

        return distance
        pass


if __name__ == "__main__":
    solution = Solution()
    output = solution.dijsktraDistance(0, 5, [[1, 0, 2], [2, 1, 10], [0, 2, 4], [0, 3, 5], [3, 4, 3]])
    print(output)
