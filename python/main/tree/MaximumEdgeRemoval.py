# https://www.interviewbit.com/problems/maximum-edge-removal/
class Solution:
    def solve(self, n, edges):
        graph = {i: [] for i in range(1, n + 1)}
        for a, b in edges:
            graph[a].append(b)
        counts = {}

        def dfs(node):
            if node is None:
                return 0
            if node in counts:
                return counts[node]
            count = 0
            for child in graph[node]:
                count += dfs(child)
            counts[node] = count + 1
            return counts[node]

        for i in range(1, n + 1):
            dfs(i)
        count = 0
        for a, b in edges:
            if counts[a] % 2 == 0 and counts[b] % 2 == 0:
                count += 1
        return count

        pass


if __name__ == "__main__":
    solution = Solution()
    output = solution.solve(6, [[1, 2], [1, 3], [1, 4], [3, 5], [4, 6]])
    print(output)
