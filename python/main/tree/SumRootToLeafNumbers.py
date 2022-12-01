from collections import deque
from typing import Optional, List

from python.main.tree.Tree import TreeNode, Tree


class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        def preorder(node, current: List[str], output: List[int]):
            if node is None:
                return
            current.append(str(node.val))
            if node.left is None and node.right is None:
                output.append(int("".join(current)))
            else:
                preorder(node.left, current, output)
                preorder(node.right, current, output)
                pass
            current.pop()

        output = deque()
        preorder(root, deque(), output)
        return sum(output)

        pass


if __name__ == "__main__":
    solution = Solution()
    root = Tree.createTree([1, 2, 3])
    Tree.print(root)
    output = solution.sumNumbers(root)
    print(output)
