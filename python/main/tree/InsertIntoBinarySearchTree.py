from typing import Optional

from main.tree.Tree import TreeNode, Tree


class Solution:
    def insertIntoBST(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:
        if root is None:
            return TreeNode(val)
        if val < root.val:
            root.left = self.insertIntoBST(root.left, val)
        else:
            root.right = self.insertIntoBST(root.right, val)
        return root


if __name__ == "__main__":
    solution = Solution()
    bst = Tree.createTree([4, 2, 7, 1, 3])
    Tree.print(bst)
    bst = solution.insertIntoBST(bst, 5)
    Tree.print(bst)
