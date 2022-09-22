from typing import Optional, List

from main.tree.Tree import TreeNode, Tree, null


class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        output = []

        def dfs(node, target, current):
            if node is None:
                return
            # if target - node.val < 0:
            #     return
            current.append(node.val)
            if target - node.val == 0 and node.left == node.right and node.left is None:
                output.append(list(current))
            dfs(node.left, target - node.val, current)
            dfs(node.right, target - node.val, current)
            current.pop()

        dfs(root, targetSum, [])
        return output


if __name__ == "__main__":
    solution = Solution()
    bst = Tree.createTree([5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1])
    Tree.print(bst)
    output = solution.pathSum(bst, 22)
    print(output)
