import heapq
from typing import List, Optional

from main.linkedlist.LinkedList import ListNode, LinkedList


class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        dummy = ListNode(0)
        minHeap = []

        for l in lists:
            current = l
            while current:
                heapq.heappush(minHeap, current.val)
                current = current.next

        current = dummy
        while len(minHeap) > 0:
            val = heapq.heappop(minHeap)
            current.next = ListNode(val)
            current = current.next

        return dummy.next


if __name__ == '__main__':
    s = Solution()
    lists = [
        LinkedList.create([1, 4, 5]),
        LinkedList.create([1, 3, 4]),
        LinkedList.create([2, 6]),
    ]
    result = s.mergeKLists(lists)
    print(LinkedList.print(result))
