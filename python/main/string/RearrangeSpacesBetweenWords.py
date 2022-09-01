# https://leetcode.com/problems/rearrange-spaces-between-words/
import math


class Solution:
    def reorderSpaces(self, text: str) -> str:
        spaceCount = text.count(" ")
        split = filter(lambda x: len(x) > 0, text.split(" "))
        split = list(split)
        spacePlacementCount = max(len(split) - 1, 1)

        spaceToInMiddle = math.floor(spaceCount / spacePlacementCount)
        print(split, spaceCount, spaceToInMiddle)
        for i in range(len(split) - 1):
            split[i] += "".join([" "] * spaceToInMiddle)
            spaceCount -= spaceToInMiddle

        if spaceCount > 0:
            split[-1] += "".join([" "] * spaceCount)

        return "".join(split)
        pass


if __name__ == "__main__":
    s = Solution()
    out = s.reorderSpaces("a")
    print(out)
