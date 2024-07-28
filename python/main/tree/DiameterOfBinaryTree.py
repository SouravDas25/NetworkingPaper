from typing import Optional

from main.tree.Tree import TreeNode, Tree


class Solution:

    def dfs(self, node):
        if not node:
            return 0, 0

        ld, l = self.dfs(node.left)
        rd, r = self.dfs(node.right)

        return max(ld, rd, l + r + 1), max(l, r) + 1

        pass

    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        d, l = self.dfs(root)

        return d - 1

        pass


if __name__ == '__main__':
    s = Solution()
    tree = Tree.createTree([1, 2, 3, 4, 5])
    print(Tree.print(tree))
    print(s.diameterOfBinaryTree(tree))
