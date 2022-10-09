class SegmentTree:

    def __init__(self, elements):
        self.tree = [0] * (2 * len(elements) - 1)
        self.size = len(elements)
        self.elements = elements
        for i in range(self.size):
            self.update(i, 2 * elements[i])

    def update(self, index, value):
        node = 0
        diff = value - self.elements[index]
        l = 0
        r = self.size - 1
        while l <= r and node < self.size:
            self.tree[node] += diff
            mid = l + (r - l) // 2
            if index <= mid:
                r = mid
                node = node * 2 + 1
            else:
                l = mid + 1
                node = node * 2 + 2
        pass

    def query(self, lo, hi, operation):
        pass


if __name__ == "__main__":
    segmentTree = SegmentTree([1, 2])
    print(segmentTree.tree)
