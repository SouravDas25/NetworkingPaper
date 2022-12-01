import heapq
from collections import deque
from typing import Optional

from python.main.tree.Tree import TreeNode, Tree, null


class Solution:
    def flipEquiv(self, root1, root2):
        if root1 is root2:
            return True
        if not root1 or not root2 or root1.val != root2.val:
            return False

        return (self.flipEquiv(root1.left, root2.left) and
                self.flipEquiv(root1.right, root2.right) or
                self.flipEquiv(root1.left, root2.right) and
                self.flipEquiv(root1.right, root2.left))


if __name__ == "__main__":
    solution = Solution()
    root1 = Tree.createTree([0, 3, 1, null, null, null, 2])
    Tree.print(root1)
    root2 = Tree.createTree([0, 3, 1, 2])
    Tree.print(root2)
    output = solution.flipEquiv(root1, root2)
    print(output)
