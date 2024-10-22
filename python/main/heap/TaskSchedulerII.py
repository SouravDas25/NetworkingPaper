import heapq
from collections import Counter
from typing import List

from main.heap.heaps import PriorityQueue
from main.lambdas.comparators import reverseOrder, naturalOrder


class Solution:
    def taskSchedulerII(self, tasks: List[int], space: int) -> int:
        counts = Counter(tasks)
        # print(counts)
        maxHeap = []
        for i in counts:
            heapq.heappush(maxHeap, (-counts[i], i))

        queue = []
        output = []
        current_task = "_"
        while len(maxHeap) > 0 or len(queue) > 0:
            current_task = "_"
            t = len(output)
            if len(maxHeap) > 0:
                c, task = heapq.heappop(maxHeap)
                c = -c
                c = c - 1
                current_task = task
                if c > 0:
                    queue.append((c, task, t + space))

            if len(queue) > 0:
                c, task, st = queue[0]
                if st <= t:
                    queue.pop(0)
                    heapq.heappush(maxHeap, (-c, task))

            output.append(current_task)

        print(output)

        return len(output)


if __name__ == "__main__":
    s = Solution()
    print(s.taskSchedulerII([1, 2, 1, 2, 3, 1], 3))
