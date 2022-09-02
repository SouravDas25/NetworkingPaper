from typing import Optional

from main.tree.Tree import TreeNode


class Solution:

    def inorder(self, node, minVal, maxVal, cache):
        if node is None:
            return True, None, None
        if minVal > node.val:
            return False, node.val, minVal

        if maxVal < node.val:
            return False, node.val, maxVal
        cache[node.val] = node
        lr = self.inorder(node.left, minVal, node.val)
        if not lr[0]:
            return lr
        rr = self.inorder(node.right, node.val, maxVal)
        if not rr[0]:
            return rr

        return True, None, None

    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        cache = {}
        t, v1, v2 = self.inorder(root, float("-inf"), float("inf"), cache)

        n1 = cache[v1]
        n2 = cache[v2]

        n1.val, n2.val = n2.val, n1.val
