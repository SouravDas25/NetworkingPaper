class Solution:
    def convertToTitle(self, columnNumber: int) -> str:
        output = ""
        while columnNumber > 0:
            columnNumber -= 1
            n = columnNumber % 26
            # print(n, columnNumber, output)
            columnNumber = columnNumber // 26
            output += alphabet[n]

        return output[::-1]


alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

if __name__ == "__main__":
    solution = Solution()
    output = solution.convertToTitle(701)
    print(output)
