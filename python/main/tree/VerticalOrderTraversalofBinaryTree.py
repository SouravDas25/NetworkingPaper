from collections import defaultdict
from typing import Optional, List

from main.tree.Tree import TreeNode, null, Tree


class Solution:
    def verticalTraversal(self, root: Optional[TreeNode]) -> List[List[int]]:
        verticalOrders = {}

        def dfs(node, verticalOrder, level):
            if node is None:
                return
            if verticalOrder not in verticalOrders:
                verticalOrders[verticalOrder] = {}
            if level not in verticalOrders[verticalOrder]:
                verticalOrders[verticalOrder][level] = []

            verticalOrders[verticalOrder][level].append(node.val)
            dfs(node.left, verticalOrder - 1, level + 1)
            dfs(node.right, verticalOrder + 1, level + 1)

        dfs(root, 0, 0)
        print(verticalOrders)
        output = []
        for key in sorted(verticalOrders.keys()):
            vl = []
            for level in verticalOrders[key]:
                verticalOrders[key][level].sort()
                vl.extend(verticalOrders[key][level])
            output.append(vl)
        return output

        pass


if __name__ == "__main__":
    solution = Solution()
    tree = Tree.createTree([0,8,1,null,null,3,2,null,4,5,null,null,7,6])
    Tree.print(tree)
    output = solution.verticalTraversal(tree)
    print(output)
