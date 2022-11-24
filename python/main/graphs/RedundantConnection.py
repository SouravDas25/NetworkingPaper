from typing import List


class Solution:

    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        parent = {}
        rank = {}

        def find(node):
            while parent[node] != node:
                parent[node] = parent[parent[node]]
                node = parent[node]
            return parent[node]

        for s, d in edges:
            if s not in parent:
                parent[s] = s
                rank[s] = 1
            if d not in parent:
                parent[d] = d
                rank[d] = 1

            ps = find(s)
            pd = find(d)

            if ps != pd:
                if rank[ps] > rank[pd]:
                    parent[pd] = ps
                    rank[ps] += 1
                else:
                    parent[ps] = pd
                    rank[pd] += 1
            else:
                return [s, d]
        return -1
        pass


if __name__ == "__main__":
    solution = Solution()
    output = solution.findRedundantConnection([[1, 2], [1, 3], [2, 3]])
    print(output)
