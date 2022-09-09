from typing import Dict, List


class Solution:

    def solve(self, n, edges):
        graph = {i: [] for i in range(1, n + 1)}

        for e1, e2 in edges:
            graph[e1].append(e2)

        global_visited = set()
        visited = set()
        stack = [i for i in range(1, n + 1)]
        while len(stack) > 0:
            node = stack[-1]
            visited.add(node)
            global_visited.add(node)
            count = 0
            for n in graph[node]:
                if n not in global_visited:
                    stack.append(n)
                    count += 1
                if n in visited:
                    return 1

            if count == 0:
                visited.remove(node)
                stack.pop()

        return 0


if __name__ == "__main__":
    solution = Solution()
    output = solution.solve(5, [[1, 2],
                                # [4, 1],
                                [2, 4],
                                [3, 4],
                                [5, 2],
                                [1, 3]])
    print(output)
