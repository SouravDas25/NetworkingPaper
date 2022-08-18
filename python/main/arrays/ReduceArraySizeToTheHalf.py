from collections import Counter
from typing import List

from main.heap.heaps import MaxHeap


class Solution:
    def minSetSize(self, arr: List[int]) -> int:
        freq = Counter(arr)
        heap = map(lambda x: (freq[x], x), freq.keys())
        heap = MaxHeap.heapify(heap)
        totalLength = len(arr)
        currentLength = totalLength
        vals = set()
        while currentLength > totalLength // 2:
            feq, val = heap.pop()
            currentLength -= feq
            vals.add(val)
        print(vals)
        return len(vals)


if __name__ == "__main__":
    s = Solution()
    c = s.minSetSize([3, 3, 3, 3, 5, 5, 5, 2, 2, 7])
    print(c)
