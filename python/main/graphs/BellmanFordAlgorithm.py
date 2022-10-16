from typing import List


class Solution:

    def bellmanFordDistanceArray(self, source, n: int, edges: List[List[int]]):
        distance = [float("inf")] * n
        distance[source] = 0

        for i in range(n - 1):
            for u, v, w in edges:
                if distance[u] + w < distance[v]:
                    distance[v] = distance[u] + w

        return distance
        pass


if __name__ == "__main__":
    solution = Solution()
    output = solution.bellmanFordDistanceArray(0, 5, [[1, 0, 2], [2, 1, 10], [0, 2, 4], [0, 3, 5], [3, 4, 3]])
    print(output)
