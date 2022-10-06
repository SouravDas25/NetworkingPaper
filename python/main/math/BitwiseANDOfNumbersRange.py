class Solution:

    def getKthBit(self, n, k):
        return (n & (1 << (k - 1))) >> (k - 1)

    def setKthBit(self, n, k):
        return (1 << (k - 1)) | n

    def rangeBitwiseAnd(self, left: int, right: int) -> int:
        output = 0
        for bit in range(1, 33):
            if (2 ** bit) // 2 >= (right - left + 1):
                leftBit = self.getKthBit(left, bit)
                rightBit = self.getKthBit(right, bit)
                if leftBit == rightBit and leftBit == 1:
                    output = self.setKthBit(output, bit)
        # print(bin(output))
        return output

        pass


if __name__ == "__main__":
    solution = Solution()
    output = solution.rangeBitwiseAnd(5, 7)
    print(output)
