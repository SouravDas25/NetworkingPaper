from typing import List


class MinHeap:

    @classmethod
    def __insert(cls, heap, size):
        i = size
        while i > 0:
            parent = (i - 1) // 2
            if heap[parent] > heap[i]:
                heap[parent], heap[i] = heap[i], heap[parent]
            i = parent

    @classmethod
    def __pop(cls, heap, size):
        heap[0], heap[size] = heap[size], heap[0]
        i = 0
        left = i * 2 + 1
        right = i * 2 + 2
        while right < size or left < size:
            if (not right < size) or heap[left] <= heap[right]:
                if heap[left] < heap[i]:
                    heap[left], heap[i] = heap[i], heap[left]
                    i = left
                else:
                    break
            else:
                if heap[right] < heap[i]:
                    heap[right], heap[i] = heap[i], heap[right]
                    i = right
                else:
                    break
            left = i * 2 + 1
            right = i * 2 + 2

    @classmethod
    def heapify(cls, iterable: List):
        for i in range(len(iterable)):
            cls.__insert(iterable, i)

    @classmethod
    def insert(cls, heap, value):
        value.append(value)
        cls.__insert(heap, len(heap) - 1)

    @classmethod
    def pop(cls, heap):
        cls.__pop(heap, len(heap) - 1)
        return heap.pop()

    @classmethod
    def heapsort(cls, iterable: List):
        cls.heapify(iterable)
        # print(minHeap.heap)
        for i in range(len(iterable) - 1, -1, -1):
            cls.__pop(iterable, i)
            # print(minHeap.heap, minHeap.heap[i], i)
        iterable.reverse()


class Solution:

    def heapsort(self, list):
        MinHeap.heapsort(list)
        return list


if __name__ == "__main__":
    solution = Solution()
    output = solution.heapsort([2, 5, 8, 3, 5, 9, 3])
    print(output)
