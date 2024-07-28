import heapq
from collections import Counter


class Solution:
    def reorganizeString(self, s: str) -> str:
        uniq = Counter(s)
        print(uniq)
        maxHeap = []
        for char in uniq:
            count = uniq[char]
            heapq.heappush(maxHeap, (-count, char))

        ans = ""
        while len(maxHeap) > 0:
            count, char = heapq.heappop(maxHeap)
            count = -count

            ans += char
            count -= 1

            if len(maxHeap) <= 0:
                if count > 0:
                    return ""
                break

            count2, char2 = heapq.heappop(maxHeap)
            count2 = -count2

            ans += char2
            count2 -= 1

            if count2 > 0:
                heapq.heappush(maxHeap, (-count2, char2))

            if count > 0:
                heapq.heappush(maxHeap, (-count, char))

        return ans
        pass


if __name__ == '__main__':
    s = Solution()
    print(s.reorganizeString('aaab'))
