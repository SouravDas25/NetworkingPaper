import heapq
from collections import defaultdict, deque
from typing import List, Dict, Iterable


class Solution:
    def numBusesToDestination(self, routes: List[List[int]], source: int, target: int) -> int:
        if source == target:
            return 0
        busToStops = {}
        stopToBuses = defaultdict(set)
        for busId, stops in enumerate(routes):
            busToStops[busId] = set(stops)
            for stop in stops:
                stopToBuses[stop].add(busId)

        graph = defaultdict(set)
        for busId1 in range(len(routes)):
            for busId2 in range(busId1 + 1, len(routes)):
                if len(busToStops[busId1].intersection(busToStops[busId2])) > 0:
                    graph[busId1].add(busId2)
                    graph[busId2].add(busId1)

        # visualize(graph, busToStops)
        queue = deque(stopToBuses[source])
        targets = stopToBuses[target]
        visited = set()
        level = 0
        while len(queue) > 0:
            level += 1
            for _ in range(len(queue)):
                busId = queue.popleft()
                if busId in targets:
                    return level
                visited.add(busId)
                for nextBusId in graph[busId]:
                    if nextBusId not in visited:
                        queue.append(nextBusId)
        return -1


def visualize(graph: Dict[int, Iterable], busToStops):
    from pyvis.network import Network
    network = Network()
    for busId in graph:
        network.add_node(busId, label=(str(busId) + str(busToStops[busId])))

    for busId in graph:
        for nextVertex in graph[busId]:
            network.add_edge(busId, nextVertex)
    network.show('nx.html')


if __name__ == "__main__":
    s = Solution()
    # minstop = s.numBusesToDestination([[1, 2, 7], [3, 6, 7]], 1, 6)
    # print(minstop)
    # minstop = s.numBusesToDestination([[7, 12], [4, 5, 15], [6], [15, 19], [9, 12, 13]], 15, 12)
    # print(minstop)
    # minstop = s.numBusesToDestination([[1, 2, 3, 4, 5, 6, 7, 8, 9], [8, 5]], 8, 4)
    # print(minstop)
    minstop = s.numBusesToDestination([[1, 7], [3, 5]], 5, 5)
    print(minstop)
