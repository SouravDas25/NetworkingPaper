from typing import Optional

from python.main.tree.Tree import TreeNode, Tree, null


class Solution:
    def trimBST(self, root: Optional[TreeNode], low: int, high: int) -> Optional[TreeNode]:
        def trim(node: TreeNode):
            if node is None:
                return None

            if node.val < low:
                node.right = trim(node.right)
                return node.right
            elif node.val > high:
                node.left = trim(node.left)
                return node.left
            else:
                node.right = trim(node.right)
                node.left = trim(node.left)
                return node

        root = trim(root)

        return root


if __name__ == "__main__":
    solution = Solution()
    bst = Tree.createTree([3, 0, 4, null, 2, null, null, 1])
    Tree.print(bst)
    bst = solution.trimBST(bst, 1, 3)
    Tree.print(bst)
