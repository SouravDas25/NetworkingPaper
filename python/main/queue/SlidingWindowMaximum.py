from sortedcontainers import SortedList
from collections import deque
import heapq
from typing import List


class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        maxQueue = MaxQueue()
        for i in range(0, k):
            maxQueue.push(nums[i])
        output = [maxQueue.getMax()]
        i = k
        while i < len(nums):
            maxQueue.pop()
            maxQueue.push(nums[i])
            output.append(maxQueue.getMax())
            i += 1
        return output


class MaxQueue(object):
    def __init__(self):
        self.maxs, self.nums = deque(), deque()

    def push(self, num):
        self.nums.append(num)
        while self.maxs and self.maxs[-1] < num:
            self.maxs.pop()
        self.maxs.append(num)

    def pop(self):
        val = self.nums.popleft()
        if val == self.maxs[0]:
            self.maxs.popleft()
        return val

    def getMax(self):
        return self.maxs[0]

    def empty(self):
        return len(self.nums) != 0


if __name__ == "__main__":
    s = Solution()
    print(s.maxSlidingWindow([1, 3, -1, -3, 5, 3, 6, 7], 3))
