import heapq


class Solution:
    def solve(self, n, edges):
        graph = {i: [] for i in range(1, n + 1)}

        for e1, e2, w in edges:
            graph[e1].append((e2, w))

        minHeap = [(0, 1)]
        visited = set()
        minCost = 0
        while len(visited) < n:
            w, node = heapq.heappop(minHeap)
            visited.add(node)
            minCost += w
            for e2, w in graph[node]:
                if e2 not in visited:
                    heapq.heappush(minHeap, (w, e2))
        return minCost


if __name__ == "__main__":
    solution = Solution()
    output = solution.solve(4, [[1, 2, 1],
                                [2, 3, 4],
                                [1, 4, 3],
                                [4, 3, 2],
                                [1, 3, 10]])
    print(output)
