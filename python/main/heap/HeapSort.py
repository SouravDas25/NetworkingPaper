from typing import List


class MinHeap:

    def __init__(self, randomAccess):
        self.heap: List = randomAccess
        self.heapify()

    def __insert(self, size):
        i = size
        while i > 0:
            parent = (i - 1) // 2
            if self.heap[parent] > self.heap[i]:
                self.heap[parent], self.heap[i] = self.heap[i], self.heap[parent]
            i = parent

    def __pop(self, size):
        self.heap[0], self.heap[size] = self.heap[size], self.heap[0]
        i = 0
        left = i * 2 + 1
        right = i * 2 + 2
        while right < size or left < size:
            if (not right < size) or self.heap[left] <= self.heap[right]:
                if self.heap[left] < self.heap[i]:
                    self.heap[left], self.heap[i] = self.heap[i], self.heap[left]
                    i = left
                else:
                    break
            else:
                if self.heap[right] < self.heap[i]:
                    self.heap[right], self.heap[i] = self.heap[i], self.heap[right]
                    i = right
                else:
                    break
            left = i * 2 + 1
            right = i * 2 + 2

    def heapify(self):
        for i in range(len(self.heap)):
            self.__insert(i)

    def insert(self, key):
        self.heap.append(key)
        self.__insert(len(self.heap) - 1)

    def pop(self):
        self.__pop(len(self.heap) - 1)
        return self.heap.pop()

    def __len__(self):
        return self.heap.__len__()

    @staticmethod
    def heapsort(iterable: List):
        minHeap = MinHeap(iterable)
        # print(minHeap.heap)
        for i in range(len(minHeap) - 1, -1, -1):
            minHeap.__pop(i)
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
