from collections import deque

from main.tree.Tree import Tree

# https://www.interviewbit.com/problems/covered-uncovered-nodes/
class Solution:

    def coveredNodes(self, root):

        uncoveredSum = 0
        coveredSum = 0
        queue = deque([root])
        while len(queue) > 0:
            size = len(queue)
            if size == 1:
                uncoveredSum += queue[0].val
            else:
                uncoveredSum += queue[0].val
                uncoveredSum += queue[-1].val
            print(queue, uncoveredSum)
            for _ in range(size):
                node = queue.popleft()
                coveredSum += node.val
                if node.left is not None:
                    queue.append(node.left)
                if node.right is not None:
                    queue.append(node.right)
        return abs(coveredSum - uncoveredSum * 2)


if __name__ == "__main__":
    solution = Solution()
    root = Tree.createTree([2, 1, 4, 6, None, 10, 5])
    Tree.print(root)
    output = solution.coveredNodes(root)
    print(output)
