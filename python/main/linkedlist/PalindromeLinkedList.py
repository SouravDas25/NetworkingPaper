from typing import Optional

from main.linkedlist.LinkedList import ListNode, LinkedList


class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        if head is None:
            return False
        if head.next is None:
            return True
        count = LinkedList.length(head)
        prev, mid = LinkedList.mid(head)
        prev.next = None
        if count % 2 == 1:
            mid = mid.next
        mid = LinkedList.reverse(mid)
        # LinkedList.print(head)x
        # LinkedList.print(mid)
        return LinkedList.equal(head, mid)
        pass


if __name__ == "__main__":
    solution = Solution()
    output = solution.isPalindrome(LinkedList.create([1, 2, 1]))
    print(output)
