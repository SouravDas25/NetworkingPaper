from typing import List, Optional

from main.tree.Tree import Tree, TreeNode


class ConvertSortedArray2BinarySearchTree:

    def _recursion(self, l, h, nums):
        if l > h:
            return None
        mid = l + (h - l) // 2
        node = TreeNode(nums[mid])
        node.left = self._recursion(l, mid - 1, nums)
        node.right = self._recursion(mid + 1, h, nums)
        return node

    def sortedArrayToBST(self, nums: List[int]) -> Optional[TreeNode]:
        return self._recursion(0, len(nums) - 1, nums)


if __name__ == "__main__":
    cs = ConvertSortedArray2BinarySearchTree()
    tree = cs.sortedArrayToBST([-10, -3, 0, 5, 9])
    Tree.print(tree)
