from typing import Optional

from main.linkedlist.LinkedList import LinkedList, ListNode
from main.tree.Tree import TreeNode, Tree


class Solution:
    def findMiddle(self, head: ListNode):
        sp = head
        fp = head
        prev = None
        while fp is not None and fp.next is not None:
            prev = sp
            sp = sp.next
            fp = fp.next.next
        return prev

    def sortedListToBST(self, head: Optional[ListNode]) -> Optional[TreeNode]:
        if head is None:
            return None
        if head.next is None:
            return TreeNode(head.val)

        mid = self.findMiddle(head)
        node = TreeNode(mid.next.val)
        node.right = self.sortedListToBST(mid.next.next)
        mid.next = None
        node.left = self.sortedListToBST(head)

        return node


if __name__ == "__main__":
    s = Solution()
    linkedlist = LinkedList.create([-10, -3, 0, 5, 9, 11])
    LinkedList.print(linkedlist)
    bst = s.sortedListToBST(linkedlist)
    Tree.print(bst)
