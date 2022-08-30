from typing import Optional

from main.tree.Tree import Tree, TreeNode


class Solution:
    def searchBST(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:
        if root is None:
            return None
        if root.val == val:
            return root
        if val < root.val:
            return self.searchBST(root.left, val)
        else:
            return self.searchBST(root.right, val)


if __name__ == "__main__":
    solution = Solution()
    bst = Tree.createTree([4, 2, 7, 1, 3])
    Tree.print(bst)
    subtree = solution.searchBST(bst, 2)
    Tree.print(subtree)
