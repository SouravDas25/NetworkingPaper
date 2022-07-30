from typing import List, Optional

from main.tree.Tree import TreeNode


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
