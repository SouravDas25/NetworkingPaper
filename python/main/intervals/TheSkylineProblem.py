import heapq
from typing import List
from unittest import TestCase


class Skyline:
    def isOverlapping(self, a, b):
        return a[0] <= b[0] <= a[1] or a[0] <= b[1] <= a[1]

    def merge(self, a, b):
        return [min(a[0], b[0]), max(a[1], b[1])]

    def mergePoints(self, output):
        nl = [output[0]]
        for i in range(1, len(output)):
            curr = nl[-1]
            if curr[0] == output[i][0]:
                nl[-1][1] = output[i][1]
            else:
                nl.append(output[i])
        output = [nl[0]]
        for i in range(1, len(nl)):
            curr = output[-1]
            if curr[1] == nl[i][1]:
                continue
            else:
                output.append(nl[i])
        return output

    def computeGroup(self, groups):
        points = []
        for item in groups:
            heapq.heappush(points, (item[0], item[2], "S"))
            heapq.heappush(points, (item[1], item[2], "E"))

        heights = []
        output = []
        while len(points) - 1 > 0:
            x, y, ty = heapq.heappop(points)
            if ty == "S":
                heapq.heappush(heights, -y)
            else:
                i = heights.index(-y)
                heights[i] = heights[-1]
                heights.pop()
                heapq.heapify(heights)

            if len(heights) > 0:
                output.append([x, -heights[0]])
        x, y, ty = heapq.heappop(points)
        output.append([x, 0])
        return output

    def getSkyline(self, buildings: List[List[int]]) -> List[List[int]]:
        if len(buildings) < 1:
            return []
        buildings.sort()
        i = 0
        j = i
        goupCount = 0
        groups = {}
        while j < len(buildings):
            if i == j:
                groups[goupCount] = [buildings[i]]
                merged = [buildings[i][0], buildings[i][1]]
                j += 1
                continue
            if self.isOverlapping(merged, buildings[j]):
                merged = self.merge(merged, buildings[j])
                groups[goupCount].append(buildings[j])
                j += 1
            else:
                goupCount += 1
                i = j
        print(groups)
        output = []
        for group in groups:
            output.extend(self.computeGroup(groups[group]))
        return self.mergePoints(output)


class Test(TestCase):
    def test_solution(self):
        s = Skyline()
        output = s.getSkyline([[1,2,1],[1,2,2],[1,2,3],[2,3,1],[2,3,2],[2,3,3]])
        print(output)
