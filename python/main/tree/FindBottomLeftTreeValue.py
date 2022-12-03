from collections import deque
from typing import Optional

from python.main.tree.Tree import TreeNode


class Solution:
    def findBottomLeftValue(self, root: Optional[TreeNode]) -> int:

        def levelOrder(node):
            levels = []
            queue = deque([node])
            while len(queue) > 0:
                size = len(queue)
                level = []
                for _ in range(size):
                    node = queue.popleft()
                    level.append(node.val)
                    if node.left is not None:
                        queue.append(node.left)
                    if node.right is not None:
                        queue.append(node.right)
                levels.append(level)
            return levels

        levels = levelOrder(root)
        return levels[-1][0] if root is not None else None
