from typing import List

from python.main.tree.Tree import TreeNode, Tree

# https://leetcode.com/problems/all-possible-full-binary-trees/
class Solution:
    memo = {0: [], 1: [TreeNode(0)]}

    def allPossibleFBT(self, N):
        if N not in Solution.memo:
            ans = []
            for x in range(N):
                y = N - 1 - x
                for left in self.allPossibleFBT(x):
                    for right in self.allPossibleFBT(y):
                        bns = TreeNode(0)
                        bns.left = left
                        bns.right = right
                        ans.append(bns)
            Solution.memo[N] = ans

        return Solution.memo[N]


if __name__ == "__main__":
    solution = Solution()
    output = solution.allPossibleFBT(7)
    for tree in output:
        print("=======")
        Tree.print(tree)
