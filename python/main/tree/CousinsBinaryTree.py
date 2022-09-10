from typing import Optional

from main.tree.Tree import TreeNode, Tree, null

# https://www.interviewbit.com/problems/cousins-in-binary-tree/
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        parent = {root: None}
        levels = {root: 0}

        def dfs(node, level):
            if node is None:
                return
            levels[node.val] = level
            if node.left:
                parent[node.left.val] = node
                dfs(node.left, level + 1)
            if node.right:
                parent[node.right.val] = node
                dfs(node.right, level + 1)

        dfs(root, 0)

        return levels[x] == levels[y] and parent[x] != parent[y]


if __name__ == "__main__":
    solution = Solution()
    root = Tree.createTree([1, 2, 3, null, 4, null, 5])
    output = solution.isCousins(root, 5, 4)
    print(output)
