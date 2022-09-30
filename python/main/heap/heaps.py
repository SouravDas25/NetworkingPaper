from typing import List, Callable, Deque

from main.lambdas.comparators import Comparable, naturalOrder


class Heap:

    @classmethod
    def __insert(cls,
                 heap: List[Comparable],
                 index: int,
                 comparator: Callable[[Comparable, Comparable], int] = None):
        comparator = naturalOrder if comparator is None else comparator
        i = index
        while i > 0:
            parent = (i - 1) // 2
            if comparator(heap[parent], heap[i]) > 0:
                heap[parent], heap[i] = heap[i], heap[parent]
            i = parent

    @classmethod
    def __pop(cls,
              heap: List[Comparable],
              lastIndex: int,
              comparator: Callable[[Comparable, Comparable], int] = None):
        comparator = naturalOrder if comparator is None else comparator
        heap[0], heap[lastIndex] = heap[lastIndex], heap[0]
        i = 0
        left = i * 2 + 1
        right = i * 2 + 2
        while right < lastIndex or left < lastIndex:
            if (not right < lastIndex) or comparator(heap[left], heap[right]) < 1:
                if comparator(heap[left], heap[i]) < 0:
                    heap[left], heap[i] = heap[i], heap[left]
                    i = left
                else:
                    break
            else:
                if comparator(heap[right], heap[i]) < 0:
                    heap[right], heap[i] = heap[i], heap[right]
                    i = right
                else:
                    break
            left = i * 2 + 1
            right = i * 2 + 2

    @classmethod
    def heapify(cls, iterable: List[Comparable], comparator: Callable[[Comparable, Comparable], int] = None):
        for i in range(len(iterable)):
            cls.__insert(iterable, i, comparator)

    @classmethod
    def insert(cls, heap: List[Comparable],
               value: Comparable,
               comparator: Callable[[Comparable, Comparable], int] = None):
        heap.append(value)
        cls.__insert(heap, len(heap) - 1, comparator)

    @classmethod
    def pop(cls, heap: List[Comparable], comparator: Callable[[Comparable, Comparable], int] = None):
        cls.__pop(heap, len(heap) - 1, comparator)
        return heap.pop()

    @classmethod
    def heapsort(cls, iterable: List[Comparable], comparator: Callable[[Comparable, Comparable], int] = None):
        cls.heapify(iterable, comparator)
        # print(minHeap.heap)
        for i in range(len(iterable) - 1, -1, -1):
            cls.__pop(iterable, i, comparator)
            # print(minHeap.heap, minHeap.heap[i], i)
        # iterable.reverse()


class PriorityQueue:

    def __init__(self, comparator: Callable[[Comparable, Comparable], int],
                 iterable: List[Comparable] = None):
        self.comparator = comparator
        self.heap = [] if iterable is None else iterable
        Heap.heapify(self.heap, self.comparator)

    def pop(self) -> Comparable:
        return Heap.pop(self.heap, self.comparator)

    def insert(self, value):
        Heap.insert(self.heap, value, self.comparator)

    def __len__(self):
        return self.heap.__len__()

    def __str__(self):
        return self.heap.__str__()

    def __repr__(self):
        return self.heap.__repr__()
