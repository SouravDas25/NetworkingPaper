from typing import Optional

from main.tree.Tree import TreeNode, Tree


# https://leetcode.com/problems/recover-binary-search-tree/
class Solution:

    def inorder(self, node, output):
        if node is None:
            return
        self.inorder(node.left, output)
        output.append(node.val)
        self.inorder(node.right, output)

    def inorderFix(self, node, sv1, sv2):
        if node is None:
            return
        self.inorderFix(node.left, sv1, sv2)
        if node.val == sv1:
            node.val = sv2
        elif node.val == sv2:
            node.val = sv1
        self.inorderFix(node.right, sv1, sv2)

    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        output = []
        self.inorder(root, output)
        mapping = {}
        for i, n in enumerate(sorted(output)):
            mapping[n] = i
        # print(mapping, output)
        for i in range(len(output)):
            n = output[i]
            if mapping[n] != i:
                sv1 = n
                sv2 = output[mapping[n]]
                # print(sv1, sv2)
                self.inorderFix(root, sv1, sv2)
                break
        # done


if __name__ == "__main__":
    s = Solution()
    bst = Tree.createTree([3, None, 2, None, 1])
    Tree.print(bst)
    s.recoverTree(bst)
    Tree.print(bst)
