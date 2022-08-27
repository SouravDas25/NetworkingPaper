import heapq
from collections import defaultdict, deque
from typing import List


class Solution:
    def numBusesToDestination(self, routes: List[List[int]], source: int, target: int) -> int:
        graph = defaultdict(list)
        for busId, route in enumerate(routes):
            prevStop = route[0]
            for j in range(1, len(route)):
                graph[prevStop].append((route[j], busId))
                graph[route[j]].append((prevStop, busId))
                prevStop = route[j]

        print(graph)
        minHeap = [(0, 0, source, None)]
        visited = set()
        count = 1
        while len(minHeap) > 0:
            busCount, cnt, currentStop, prevBus = heapq.heappop(minHeap)
            print(currentStop, busCount, prevBus)
            if currentStop == target:
                return busCount
            visited.add((currentStop, prevBus))
            for nextStop, currentBus in graph[currentStop]:
                nbc = busCount + (1 if currentBus != prevBus else 0)
                if (nextStop, currentBus) not in visited:
                    heapq.heappush(minHeap,
                                   (nbc, count, nextStop, currentBus))
                    count += 1
        return -1


if __name__ == "__main__":
    s = Solution()
    minstop = s.numBusesToDestination([[1, 2, 7], [3, 6, 7]], 1, 6)
    print(minstop)
    minstop = s.numBusesToDestination([[7, 12], [4, 5, 15], [6], [15, 19], [9, 12, 13]], 15, 12)
    print(minstop)
    minstop = s.numBusesToDestination([[1, 2, 3, 4, 5, 6, 7, 8, 9], [8, 5]], 8, 4)
    print(minstop)
