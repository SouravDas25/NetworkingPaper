class Node:

    def __init__(self, val, next=None, random=None):
        self.val = val
        self.next = next
        self.random = None


# https://leetcode.com/problems/copy-list-with-random-pointer/

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        # random = {}
        nodeMappings = {}  # old node -> new node
        current = head
        dummy = Node(0)
        newList = dummy
        while current is not None:
            newList.next = Node(current.val)
            nodeMappings[current] = newList.next
            newList = newList.next
            current = current.next

        current = head
        newList = dummy.next
        while current is not None:
            if current.random is not None:
                newList.random = nodeMappings[current.random]
            current = current.next
            newList = newList.next

        return dummy.next


if __name__ == "__main__":
    s = Solution()
    b = s.copyRandomList()
    print(b)
