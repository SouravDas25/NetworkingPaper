class Solution:
    # @param A : integer
    # @param B : list of list of integers
    # @return an integer
    def find(self, n, parent):
        while parent[n] != n:
            parent[n] = parent[parent[n]]
            n = parent[n]
        return parent[n]

    def solve(self, n, edges):
        parent = {}
        rank = {}
        for i in range(1, n + 1):
            parent[i] = i
            rank[i] = 1

        for e1, e2 in edges:
            p1 = self.find(e1, parent)
            p2 = self.find(e2, parent)
            if p1 != p2:
                if rank[p1] < rank[p2]:
                    parent[p2] = p1
                    rank[p1] += 1
                else:
                    parent[p1] = p2
                    rank[p2] += 1
            else:
                return 1
        return 0

        # for key in range(parent):
        #     p = self.find(key, parent)
        #     parent[key] = p


if __name__ == "__main__":
    solution = Solution()
    output = solution.solve(5, [[1, 2],
                                [1, 3],
                                [2, 3],
                                [1, 4],
                                [4, 5]])
    print(output)
