from collections import defaultdict
from typing import List


class Solution:

    def dfs(self, graph, visited, stack, vertex):
        visited.add(vertex)
        for e in graph[vertex]:
            if e not in visited:
                self.dfs(graph, visited, stack, e)
        stack.append(vertex)

    def transpose(self, graph):
        ng = defaultdict(list)
        for v in graph:
            for e in graph[v]:
                ng[e].append(v)
        return ng

    def dfs2(self, transpose, v, visited):
        visited.add(v)
        output = [v]
        for e in transpose[v]:
            if e not in visited:
                output.extend(self.dfs2(transpose, e, visited))
        return output

    def stronglyConnectedComponents(self, n: int, edges: List[List[int]]):
        graph = defaultdict(list)
        for s, d in edges:
            graph[s].append(d)

        stack = []
        visited = set()

        for v in range(n):
            if v not in visited:
                self.dfs(graph, visited, stack, v)

        print(stack)

        transpose = self.transpose(graph)
        visited = set()
        output = []
        while stack:
            v = stack.pop()
            if v not in visited:
                output.append(self.dfs2(transpose, v, visited))
        return output


if __name__ == "__main__":
    solution = Solution()
    output = solution.stronglyConnectedComponents(5, [[1, 0], [2, 1], [0, 2], [0, 3], [3, 4]])
    print(output)
