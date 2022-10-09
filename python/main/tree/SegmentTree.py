from typing import List, Dict


def getCapacity(size: int) -> int:
    i = 0
    while 2 ** i < size:
        i += 1
    return (2 ** i) * 2 - 1


SUM = 0
MIN = 1
MAX = 2


class SegmentTree:

    def __init__(self, elements):
        self.capacity = getCapacity(len(elements))
        self.tree: List[Dict] = [None] * self.capacity
        self.size = len(elements)
        self.elements = elements
        for i in range(self.capacity):
            self.tree[i] = [0, float("inf"), float("-inf")]
        for i in range(self.size):
            self.__update(i, elements[i], False)

    def __update(self, index, value, withDiff=True):
        node = 0
        low = 0
        diff = value
        if withDiff:
            diff = value - self.elements[index]
        high = self.size - 1
        while node < len(self.tree) and low <= high:
            self.tree[node][SUM] += diff
            mid = low + (high - low) // 2
            if index <= mid:
                high = mid
                node = node * 2 + 1
            else:
                low = mid + 1
                node = node * 2 + 2

        node = (node - 1) // 2
        self.tree[node][MIN] = value
        self.tree[node][MAX] = value
        while node > 0:
            node = (node - 1) // 2
            left = node * 2 + 1
            right = node * 2 + 2
            self.tree[node][MIN] = min(self.tree[left][MIN], self.tree[right][MIN])
            self.tree[node][MAX] = max(self.tree[left][MAX], self.tree[right][MAX])
        pass

    def update(self, index, value):
        self.__update(index, value)
        self.elements[index] = value

    def __reduce(self, lo, hi, low, high, node, reductionLambda):
        mid = low + (high - low) // 2
        if hi < low:
            return reductionLambda["UOOB"]()
        if lo > high:
            return reductionLambda["LOOB"]()
        if low == lo and high == hi:
            return reductionLambda["EXACT"](self.tree[node])
        left = self.__reduce(max(lo, low), min(mid, hi), low, mid, node * 2 + 1, reductionLambda)
        right = self.__reduce(max(mid + 1, lo), min(hi, high), mid + 1, high, node * 2 + 2, reductionLambda)
        return reductionLambda["REDUCE"](left, right)

    def reduce(self, lo, hi, reductionLambda):
        return self.__reduce(lo, hi, 0, self.size - 1, 0, reductionLambda)

    def sum(self, lo, hi):
        reductionLambda = {
            "REDUCE": lambda a, b: a + b,
            "UOOB": lambda: 0,
            "LOOB": lambda: 0,
            "EXACT": lambda value: value[SUM]
        }
        return self.reduce(lo, hi, reductionLambda)

    def min(self, lo, hi):
        reductionLambda = {
            "REDUCE": lambda a, b: min(a, b),
            "UOOB": lambda: float("inf"),
            "LOOB": lambda: float("inf"),
            "EXACT": lambda value: value[MIN]
        }
        return self.reduce(lo, hi, reductionLambda)

    def max(self, lo, hi):
        reductionLambda = {
            "REDUCE": lambda a, b: max(a, b),
            "UOOB": lambda: float("-inf"),
            "LOOB": lambda: float("-inf"),
            "EXACT": lambda value: value[MAX]
        }
        return self.reduce(lo, hi, reductionLambda)

    def print(self, prefix="", node=0, isLeft=False, low=None, high=None):
        if low is None:
            low = 0
        if high is None:
            high = self.size - 1
        if node < len(self.tree):
            print(prefix + ("L-- " if isLeft else "R-- "), "({} - {})".format(low, high), str(self.tree[node]))
            mid = low + (high - low) // 2
            self.print(prefix + ("|   " if isLeft else "    "), node * 2 + 1, True, low, mid)
            self.print(prefix + ("|   " if isLeft else "    "), node * 2 + 2, False, mid + 1, high)


if __name__ == "__main__":
    segmentTree = SegmentTree([7, 2, 7, 2, 0])
    segmentTree.update(4, 6)
    segmentTree.update(0, 2)
    segmentTree.update(0, 9)
    print(segmentTree.sum(4, 4))
    segmentTree.update(3, 8)
    print(segmentTree.sum(0, 4))
    segmentTree.print()
    segmentTree.update(4, 1)
    print(segmentTree.sum(0, 3))
    print(segmentTree.sum(0, 4))
    segmentTree.update(0, 4)
    segmentTree.print()
