class SegmentTree:

    def __init__(self, elements):
        self.tree = [0] * (self.getCapacity(len(elements)))
        self.size = len(elements)
        self.elements = elements
        for i in range(self.size):
            self.update(i, 2 * elements[i])

    def getCapacity(self, size):
        i = 0
        while 2 ** i < size:
            i += 1
        return (2 ** i) * 2 - 1

    def update(self, index, value):
        node = 0
        diff = value - self.elements[index]
        low = 0
        high = self.size - 1
        while node < len(self.tree) and low <= high:
            self.tree[node] += diff
            mid = low + (high - low) // 2
            if index <= mid:
                high = mid
                node = node * 2 + 1
            else:
                low = mid + 1
                node = node * 2 + 2
        pass

    def sum(self, lo, hi, low=None, high=None, node=0):
        if low is None:
            low = 0
        if high is None:
            high = self.size - 1

        mid = low + (high - low) // 2
        if low == lo and high == hi:
            return self.tree[node]
        return self.sum(lo, mid, low, mid, node * 2 + 1) + self.sum(mid + 1, hi, mid + 1, high, node * 2 + 2)

    def print(self, prefix="", node=0, isLeft=False, low=None, high=None):
        if low is None:
            low = 0
        if high is None:
            high = self.size - 1
        if node < len(self.tree):
            print(prefix + ("L-- " if isLeft else "R-- ") + str(self.tree[node]), "({} - {})".format(low, high))
            mid = low + (high - low) // 2
            self.print(prefix + ("|   " if isLeft else "    "), node * 2 + 1, True, low, mid)
            self.print(prefix + ("|   " if isLeft else "    "), node * 2 + 2, False, mid + 1, high)


if __name__ == "__main__":
    segmentTree = SegmentTree([1, 2, 3, 4, 5, 6, 7])
    print(segmentTree.sum(0, 5))
    print(segmentTree.tree)
    segmentTree.print()
