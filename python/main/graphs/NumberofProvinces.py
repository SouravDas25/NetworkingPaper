from collections import Counter
from typing import List


class Solution:

    def find(self, n, parent):
        while parent[n] != n:
            parent[n] = parent[parent[n]]
            n = parent[n]
        return parent[n]

    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        parent = []
        rank = []
        for i in range(len(isConnected)):
            parent.append(i)
            rank.append(1)

        for i in range(len(isConnected)):
            for j in range(len(isConnected[i])):
                if isConnected[i][j] == 1 and j != i:
                    p1 = self.find(i, parent)
                    p2 = self.find(j, parent)
                    if p1 != p2:
                        if rank[p1] < rank[p2]:
                            parent[p2] = p1
                            rank[p2] += 1
                        else:
                            parent[p1] = p2
                            rank[p1] += 1

        for i in range(len(isConnected)):
            p = self.find(i, parent)
            parent[i] = p
        # print(parent)
        return len(Counter(parent).keys())


if __name__ == "__main__":
    solution = Solution()
    output = solution.findCircleNum([[1, 1, 0], [1, 1, 0], [0, 0, 1]])
    print(output)
