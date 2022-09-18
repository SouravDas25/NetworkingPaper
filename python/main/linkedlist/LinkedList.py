from typing import Iterable


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class LinkedList:

    @staticmethod
    def mid(head: ListNode):
        sp = head
        fp = head
        prev = None
        while fp is not None and fp.next is not None:
            prev = sp
            sp = sp.next
            fp = fp.next.next
        return prev, sp

    @staticmethod
    def create(values: Iterable):
        dummyNode = ListNode()
        current = dummyNode
        for val in values:
            current.next = ListNode(val)
            current = current.next
        return dummyNode.next

    @staticmethod
    def toList(list: ListNode):
        nlist = []
        current = list
        while current is not None:
            nlist.append(current.val)
            current = current.next
        return nlist

    @staticmethod
    def print(linkedList: ListNode):
        print(LinkedList.toList(linkedList))

    @staticmethod
    def reverse(head: ListNode):
        prev = None
        current = head
        while current is not None:
            nn = current.next
            current.next = prev
            prev = current
            current = nn
        return prev

    @staticmethod
    def equal(head1: ListNode, head2: ListNode):
        current2 = head1
        current1 = head2
        while current1 is not None or current2 is not None:
            if current1 is None:
                return False
            if current2 is None:
                return False
            if current1.val != current2.val:
                return False
            current1 = current1.next
            current2 = current2.next

        return True

    @staticmethod
    def length(head):
        count = 0
        current = head
        while current is not None:
            count += 1
            current = current.next
        return count
