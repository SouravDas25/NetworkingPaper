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
