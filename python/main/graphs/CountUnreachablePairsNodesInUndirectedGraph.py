import collections
from typing import List


class Solution:

    def find(self, n, parent):
        while parent[n] != n:
            parent[n] = parent[parent[n]]
            n = parent[n]
        return parent[n]

    def getKeyCountsExceptSelf(self, parentCounts):
        total = 0
        for key in parentCounts:
            total += parentCounts[key]
        sumArray = {}
        for key in parentCounts:
            sumArray[key] = total - parentCounts[key]
        return sumArray

    def countPairs(self, n: int, edges: List[List[int]]) -> int:
        parent = [0] * n
        rank = [0] * n
        for i in range(n):
            parent[i] = i
            rank[i] = 1

        for fr, to in edges:
            p1 = self.find(fr, parent)
            p2 = self.find(to, parent)
            if p1 != p2:
                if rank[p1] < rank[p2]:
                    parent[p1] = p2
                    rank[p1] += 1
                else:
                    parent[p2] = p1
                    rank[p2] += 1

        for i in range(n):
            p = self.find(i, parent)
            parent[i] = p

        print(parent)

        parentCounts = collections.Counter(parent)
        print("counts", parentCounts)

        sumCounts = self.getKeyCountsExceptSelf(parentCounts)
        print("sumCounts", sumCounts)

        output = 0
        for key in parentCounts:
            output += sumCounts[key] * parentCounts[key]
        return output // 2


if __name__ == "__main__":
    solution = Solution()
    output = solution.countPairs(12, [[2, 6], [11, 3], [5, 4], [9, 6]])
    print(output)
