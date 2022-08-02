from typing import List


class UnitaryNumbers:

    def __init__(self, n: int):
        self.string = str(n)
        self.n = n

    def getString(self):
        return self.string

    def __lt__(self, other):
        return self.string + other.string < other.string + self.string

    def __str__(self):
        return self.string.__str__();

    def __repr__(self):
        return self.string.__repr__()


class LargestNumber:
    def largestNumber(self, nums: List[int]) -> str:
        # minHeap = []
        nums = map(lambda x: UnitaryNumbers(x), nums)
        nums = sorted(nums, reverse=True)
        print(list(nums))
        nums = map(UnitaryNumbers.getString, nums)
        nums = "".join(nums)
        # for i in range(len(nums)):
        #     heapq.heappush(minHeap, UnitaryNumbers(nums[i]))
        print(nums)
        # output = ""
        # while len(minHeap) > 0:
        #     output = heapq.heappop(minHeap).getString() + output
        return str(int(nums))
