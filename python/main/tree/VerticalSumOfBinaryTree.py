from collections import defaultdict

from main.tree.Tree import Tree


# https://www.interviewbit.com/problems/vertical-sum-of-a-binary-tree/
class Solution:

    def verticalSum(self, root):
        vo = defaultdict(list)

        def dfs(node, verticalOrder):
            if node is None:
                return

            vo[verticalOrder].append(node.val)
            dfs(node.left, verticalOrder - 1)
            dfs(node.right, verticalOrder + 1)

        dfs(root, 0)
        output = []
        for key in sorted(vo.keys()):
            output.append(sum(vo[key]))
        return output
        pass


if __name__ == "__main__":
    solution = Solution()
    tree = Tree.createTree([1, 2, 3, 4, 5, 6, 7])
    Tree.print(tree)
    output = solution.verticalSum(tree)
    print(output)
