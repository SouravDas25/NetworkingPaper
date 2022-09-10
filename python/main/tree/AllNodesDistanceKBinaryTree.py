from collections import deque
from typing import List

from main.tree.Tree import TreeNode, Tree, null


# https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
class Solution:
    def distanceK(self, root: TreeNode, target: TreeNode, k: int) -> List[int]:
        parents = {root: None}

        def cacheParents(node):
            if node is None:
                return
            if node.left is not None:
                parents[node.left] = node
                cacheParents(node.left)
            if node.right is not None:
                parents[node.right] = node
                cacheParents(node.right)

        cacheParents(root)

        queue = deque([target])
        visited = set()
        level = -1
        while len(queue) > 0:
            level += 1
            size = len(queue)
            print(queue)
            if level == k:
                return list(map(lambda x: x.val, queue))
            for _ in range(size):
                node = queue.popleft()
                visited.add(node)
                if node.left is not None and node.left not in visited:
                    queue.append(node.left)
                if node.right is not None and node.right not in visited:
                    queue.append(node.right)
                if parents[node] is not None and parents[node] not in visited:
                    queue.append(parents[node])
        return []


if __name__ == "__main__":
    solution = Solution()
    tree = Tree.createTree([3, 5, 1, 6, 2, 0, 8, null, null, 7, 4])
    Tree.print(tree)
    output = solution.distanceK(tree, tree.left, 2)
    print(output)
