from typing import Optional, List

from main.tree.Tree import TreeNode, Tree


# https://leetcode.com/problems/unique-binary-search-trees-ii/
class Solution:
    def generateTrees(self, n: int) -> List[Optional[TreeNode]]:
        if n == 0:
            return []
        return self.generateSubTree(1, n)

    def generateSubTree(self, start, end):
        if start > end:
            return [None]
        output = []
        for i in range(start, end + 1):
            for leftTree in self.generateSubTree(start, i - 1):
                for rightTree in self.generateSubTree(i + 1, end):
                    root = TreeNode(i)
                    output.append(root)
                    root.left = leftTree
                    root.right = rightTree
        return output


if __name__ == "__main__":
    solution = Solution()
    output = solution.generateTrees(3)
    for tree in output:
        print("=======")
        Tree.print(tree)
