import itertools
from collections import Counter, defaultdict
from typing import List, Set


class Solution:

    def splitInNEqualParts(self, string: str, ws: int):
        output = []
        for i in range(len(string)):
            if (i + 1) % ws == 0:
                output.append(string[i + 1 - ws:i + 1])
        return output

    def findSubstring(self, s: str, words: List[str]) -> Set[int]:
        js = "".join(words)
        anagram = Counter(js)
        anagram_2nd = Counter(words)
        print(anagram, anagram_2nd)
        totalWindowLength = len(js)
        ws = len(words[0])
        window = Counter()
        output = set()
        i = j = 0
        while i < len(s):
            window[s[i]] += 1
            if i - j + 1 == totalWindowLength:
                # print(window)
                if anagram == window:
                    parts = self.splitInNEqualParts(s[j:i + 1], ws)
                    print(parts)
                    ma = Counter(parts)
                    if ma == anagram_2nd:
                        output.add(j)
                window[s[j]] -= 1
                if window[s[j]] < 1:
                    del window[s[j]]
                j += 1
            i += 1
        return output


if __name__ == "__main__":
    s = Solution()
    isPossible = s.findSubstring("barfoofoobarthefoobarman", ["bar", "foo", "the"])
    print(isPossible)
