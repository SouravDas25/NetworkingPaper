import heapq


class MedianFinder:

    def __init__(self):
        self.lower = []
        self.upper = []
        self.median = None
        self.count = 0

    def addNum(self, num: int) -> None:
        self.count += 1
        isEven = self.count % 2 == 0
        if self.median is None:
            self.median = num
            heapq.heappush(self.lower, num * -1)
            return
        if num == self.median:
            if isEven:
                heapq.heappush(self.upper, num)
            else:
                heapq.heappush(self.lower, num * -1)
        elif num > self.median:
            if isEven:
                heapq.heappush(self.upper, num)
                self.median = (self.lower[0] * -1 + self.upper[0]) / 2
            else:
                heapq.heappush(self.upper, num)
                self.median = heapq.heappop(self.upper)
                heapq.heappush(self.lower, self.median * -1)
        else:
            if isEven:
                heapq.heappush(self.lower, num * -1)
                n = heapq.heappop(self.lower) * -1
                heapq.heappush(self.upper, n)
                self.median = (self.lower[0] * -1 + n) / 2
            else:
                heapq.heappush(self.lower, num * -1)
                self.median = self.lower[0] * -1

    def findMedian(self) -> float:
        return self.median


# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()

if __name__ == "__main__":
    mf = MedianFinder()
    mf.addNum(1)
    mf.addNum(2)
    assert mf.findMedian() == 1.5
    mf.addNum(3)
    assert mf.findMedian() == 2
