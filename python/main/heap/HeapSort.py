import functools
import random

from main.heap.heaps import PriorityQueue
from main.lambdas.comparators import naturalOrder, reverseOrder


class Solution:

    def heapsort(self, list):
        minHeap = PriorityQueue(naturalOrder)
        for i in range(len(list)):
            minHeap.insert(list[i])
        print(minHeap)
        for i in range(len(list)):
            list[i] = minHeap.pop()
        return list


if __name__ == "__main__":
    solution = Solution()
    list = list(range(10))
    random.shuffle(list)
    print(list)
    output = solution.heapsort(list)
    print(output)
