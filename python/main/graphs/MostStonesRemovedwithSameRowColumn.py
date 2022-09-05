from collections import Counter
from typing import List


class Solution:
    def removeStones(self, stones: List[List[int]]) -> int:
        stones = list(map(lambda x: tuple(x), stones))
        parent = {}
        rank = {}
        for i in stones:
            parent[i] = i
            rank[i] = 1

        for i in range(len(stones)):
            for j in range(len(stones)):
                if i != j and (stones[i][0] == stones[j][0] or stones[i][1] == stones[j][1]):
                    p1 = self.find(stones[i], parent)
                    p2 = self.find(stones[j], parent)
                    if p1 != p2:
                        if rank[p1] < rank[p2]:
                            parent[p1] = p2
                            rank[p2] += 1
                        else:
                            parent[p2] = p1
                            rank[p1] += 1

        for i in stones:
            parent[i] = self.find(i, parent)
        counts = Counter(parent.values())
        noOfIslands = len(counts.keys())
        # print(noOfIslands)
        return len(stones) - noOfIslands

    def find(self, i, parent):
        while parent[i] != i:
            parent[i] = parent[parent[i]]
            i = parent[i]
        return parent[i]


if __name__ == "__main__":
    solution = Solution()
    output = solution.removeStones([[0, 0], [0, 1], [1, 0], [1, 2], [2, 1], [2, 2]])
    print(output)
