from typing import Optional, List

from main.tree.Tree import TreeNode


class Solution:

    def inOrder(self, node: TreeNode, output: List):
        if node is None:
            return
        self.inOrder(node.left, output)
        output.append(node.val)
        self.inOrder(node.right, output)

    def toList(self, root):
        output = []
        self.inOrder(root, output)
        return output

    def findTarget(self, root: Optional[TreeNode], k: int) -> bool:
        values = self.toList(root)
        l = 0
        r = len(values) - 1
        while l < r:
            if values[l] + values[r] == k:
                return True

            if values[l] + values[r] < k:
                l += 1
            else:
                r -= 1
        return False
