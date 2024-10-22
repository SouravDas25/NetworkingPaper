from typing import Optional

from main.linkedlist.LinkedList import ListNode, LinkedList


class Solution:

    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if k <= 0:
            return head

        if head is None:
            return head

        count = 0
        current = head
        prev = None
        while current:
            prev = current
            current = current.next
            count += 1

        k = k % count
        kp = head
        for i in range(count - k - 1):
            kp = kp.next

        if kp.next is None:
            return head

        newHead = kp.next
        kp.next = None
        prev.next = head
        return newHead


if __name__ == '__main__':
    s = Solution()

    ll = LinkedList.create([1, 2, 3, 4, 5])

    ll = s.rotateRight(ll, 4)

    LinkedList.print(ll)
