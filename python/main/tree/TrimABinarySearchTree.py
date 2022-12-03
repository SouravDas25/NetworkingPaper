from typing import Optional

from python.main.tree.Tree import TreeNode


class Solution:
    def trimBST(self, root: Optional[TreeNode], low: int, high: int) -> Optional[TreeNode]:
        pass


if __name__ == "__main__":
    s = Solution()
    bst = Tree.createTree([3, None, 2, None, 1])
    Tree.print(bst)
    s.recoverTree(bst)
    Tree.print(bst)