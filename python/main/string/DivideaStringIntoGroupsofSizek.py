from typing import List



class Solution:
    def divideString(self, s: str, k: int, fill: str) -> List[str]:
        i = 0
        split = []
        while i < len(s):
            splitTill = min(i + k, len(s))
            substr = s[i:splitTill]
            if len(substr) < k:
                substr = substr.ljust(k, fill)
            split.append(substr)
            i += k
        return split


if __name__ == "__main__":
    s = Solution()
    sentences = s.divideString("abcdefghij", 3, "x")
    print(sentences)
