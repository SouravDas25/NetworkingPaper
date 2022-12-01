from collections import deque
from typing import Optional

from python.main.tree.Tree import Tree, TreeNode, null


class Solution:

    def rob(self, root: Optional[TreeNode]) -> int:

        def levelOrderSum(node):
            levelSums = []
            queue = deque([node])
            while len(queue) > 0:
                size = len(queue)
                levelSum = 0
                for _ in range(size):
                    node = queue.popleft()
                    levelSum += node.val
                    if node.left is not None:
                        queue.append(node.left)
                    if node.right is not None:
                        queue.append(node.right)
                levelSums.append(levelSum)
            return levelSums

        nums = levelOrderSum(root)
        # print(nums)

        dp1 = dp2 = 0
        for i in range(len(nums)):
            dp = max(nums[i] + dp2, dp1)
            dp2, dp1 = dp1, dp

        return max(dp2, dp1)
        pass


if __name__ == "__main__":
    solution = Solution()
    root = Tree.createTree([2,1,3,null,4])
    Tree.print(root)
    output = solution.rob(root)
    print(output)
