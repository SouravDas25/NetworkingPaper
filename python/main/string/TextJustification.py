from typing import List


class Solution:

    def justifyInBetween(self, row, rowLength, maxWidth):
        for i in range(maxWidth - rowLength):
            index = i % max(len(row) - 1, 1)
            row[index] += ' '
        return "".join(row)

    def leftJustify(self, row, rowLength, maxWidth):
        for i in range(maxWidth - rowLength - len(row) + 1):
            row[-1] += ' '
        return ' '.join(row)

    def fullJustify(self, words: List[str], maxWidth: int) -> List[str]:
        ans = []
        row = []
        rowLetters = 0

        for word in words:
            if rowLetters + len(word) + len(row) > maxWidth:
                ans.append(self.justifyInBetween(row, rowLetters, maxWidth))
                row = []
                rowLetters = 0
            row.append(word)
            rowLetters += len(word)

        ans.append(self.leftJustify(row, rowLetters, maxWidth))

        return ans


if __name__ == "__main__":
    s = Solution()
    sentences = s.fullJustify(["What", "must", "be", "acknowledgment", "shall", "be"], 16)
    print(sentences)
