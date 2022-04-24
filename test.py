import heapq


class KSortTuple():

    def __init__(self, n, ai):
        self.n = n
        self.ai = ai

    def __lt__(self, kst):
        return self.n.__lt__(kst.n)

    def __le__(self, kst):
        return self.n.__le__(kst.n)

    def __eq__(self, kst):
        return self.n.__eq__(kst.n)

    def __ne__(self, kst):
        return self.n.__ne__(kst.n)

    def __gt__(self, kst):
        return self.n.__gt__(kst.n)

    def __ge__(self, kst):
        return self.n.__ge__(kst.n)

    def __str__(self) -> str:
        return str(self.n)

    def __repr__(self) -> str:
        return str(self.n)


def mergeKsortedList(arrays):
    merged = []
    minHeap = []

    pointers = []

    tl = 0
    for i in range(len(arrays)):
        heapq.heappush(minHeap, KSortTuple(arrays[i][0], i))
        tl += len(arrays[i])
        pointers.append(0)

    print(minHeap)

    while len(merged) < tl:
        minItem = heapq.heappop(minHeap)
        merged.append(minItem.n)

        arrayIndex = minItem.ai

        pointers[arrayIndex] += 1
        valIndex = pointers[arrayIndex]

        print(arrayIndex, valIndex, minItem, minHeap, merged)

        if valIndex < len(arrays[arrayIndex]) :
            heapq.heappush(minHeap, KSortTuple(arrays[arrayIndex][valIndex], arrayIndex))

    return merged


arrays = [
    [1, 3, 5, 7],
    [2, 4, 6, 8],
    [0, 9, 10, 11]
]

mergeKsortedList(arrays)
