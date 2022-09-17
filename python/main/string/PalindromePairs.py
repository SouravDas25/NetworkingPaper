from collections import deque
from typing import List


class Solution:
    def palindromePairs(self, words: List[str]) -> List[List[int]]:
        rmap = {w[::-1]: i for i, w in enumerate(words)}
        res = []
        for i, wrd in enumerate(words):
            rev = wrd[::-1]
            if wrd in rmap:  # same length pair
                if rmap[wrd] != i:  # i and j should be distinct
                    res.append((i, rmap[wrd]))
            for j in range(1, len(wrd) + 1):  # first or last j characters as palindrome, other part has pair
                if wrd[:-j] in rmap and wrd[-j:] == rev[:j]:
                    res.append((i, rmap[wrd[:-j]]))
                if wrd[j:] in rmap and wrd[:j] == rev[-j:]:
                    res.append((rmap[wrd[j:]], i))
        return res


if __name__ == "__main__":
    solution = Solution()
    output = solution.palindromePairs(["abcd", "dcba", "lls", "s", "sssll"])
    print(output)
    d = deque()
    d.appendleft()
    d.insert()
