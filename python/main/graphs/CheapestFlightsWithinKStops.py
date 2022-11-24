import heapq
from collections import deque, defaultdict
from typing import List


class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        queue = deque([(0, src, 0)])

        adjList = defaultdict(set)
        for s, d, w in flights:
            adjList[s].add((d, w))

        minCost = float("inf")
        routeFound = False
        visited = set()
        while len(queue) > 0:
            cost, node, stops = queue.popleft()
            visited.add(node)
            if stops > k + 1:
                continue
            if node == dst:
                minCost = min(minCost, cost)
                routeFound = True
                continue
            for d, w in adjList[node]:
                if d not in visited:
                    queue.append((cost + w, d, stops + 1))
        return minCost if routeFound else -1


if __name__ == "__main__":
    solution = Solution()
    output = solution.findCheapestPrice(4, [[0, 1, 100], [1, 2, 100], [2, 0, 100], [1, 3, 600], [2, 3, 200]], 0, 3, 1)
    print(output)
