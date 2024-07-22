from typing import Optional

from main.linkedlist.LinkedList import ListNode, LinkedList


class Solution:

    def reverse(self, head: ListNode):
        prev = None
        current = head
        while current is not None:
            nn = current.next
            current.next = prev
            prev = current
            current = nn
        return prev

    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        # l1 = self.reverse(l1)
        # l2 = self.reverse(l2)
        carry = 0

        dummy = ListNode(0)

        current = dummy
        while l1 or l2:
            n1 = l1.val if l1 else 0
            n2 = l2.val if l2 else 0
            val = (n1 + n2 + carry) % 10
            carry = (n1 + n2 + carry) // 10
            current.next = ListNode(val)
            current = current.next
            l1 = l1.next if l1 else None
            l2 = l2.next if l2 else None

        if carry > 0:
            current.next = ListNode(carry)

        return dummy.next

        pass


if __name__ == '__main__':
    s = Solution()
    l1 = LinkedList.create([2, 4, 9])
    l2 = LinkedList.create([5, 6, 4, 9])
    l3 = s.addTwoNumbers(l1, l2)
    # print()
    LinkedList.print(l3)
