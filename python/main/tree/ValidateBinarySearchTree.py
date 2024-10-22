from typing import Optional

from main.tree.Tree import TreeNode, Tree, null


class Solution:

    def rec(self, node, minVal, maxVal):
        if not node:
            return True

        if not (minVal < node.val < maxVal):
            return False

        return self.rec(node.left, minVal, node.val) and self.rec(node.right, node.val, maxVal)

        pass

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self.rec(root, float("-inf"), float("inf"))

        pass


if __name__ == '__main__':
    s = Solution()
    bst = Tree.createTree([2,1,3])
    Tree.print(bst)
    print(s.isValidBST(bst))
