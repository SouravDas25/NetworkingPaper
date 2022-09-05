import heapq


class MaxHeapObj(object):
    def __init__(self, val):
        self.val = val

    def __lt__(self, other):
        return self.val > other.val

    def __eq__(self, other):
        return self.val == other.val

    def __str__(self):
        return self.val.__str__()

    def __repr__(self):
        return self.val.__repr__()


class MinHeap(object):
    def __init__(self, iterable=[]):
        self.h = iterable
        heapq.heapify(self.h)

    def push(self, x):
        heapq.heappush(self.h, x)

    def pop(self):
        return heapq.heappop(self.h)

    def __getitem__(self, i):
        return self.h[i]

    def __len__(self):
        return len(self.h)

    @staticmethod
    def heapify(iterable):
        return MinHeap(iterable)


class MaxHeap(MinHeap):

    def __init__(self, iterable=[]):
        self.h = list(map(lambda x: MaxHeapObj(x), iterable))
        heapq.heapify(self.h)

    def push(self, x): heapq.heappush(self.h, MaxHeapObj(x))

    def pop(self): return heapq.heappop(self.h).val

    def __getitem__(self, i): return self.h[i].val

    def __repr__(self):
        return self.h.__repr__()

    def __str__(self):
        return self.h.__str__()

    @staticmethod
    def heapify(iterable):
        return MaxHeap(iterable)
