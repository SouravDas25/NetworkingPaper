import math


class Solution:

    def findKthNum(self, nums, k):
        n = len(nums)
        ppn = math.factorial(n) // n
        b = (k - 1) // ppn
        nk = ((k - 1) % ppn) + 1
        return b, nk

    def getPermutation(self, n: int, k: int) -> str:
        nums = [i for i in range(1, n + 1)]
        output = ""
        # select one element at a time
        for i in range(n):
            index, nk = self.findKthNum(nums, k)
            output += str(nums.pop(index))
            # print(output, nums, nk)
            k = nk
        return output


if __name__ == "__main__":
    solution = Solution()
    # output = solution.getPermutation(3, 4)
    # print(output)
    for i in range(1, math.factorial(3) + 1):
        print(i, "=>", solution.getPermutation(3, i))
