import itertools


class Solution:
    def countArrangement(self, n: int) -> int:
        nums = [i for i in range(1, n + 1)]
        output = itertools.count()

        def isBeautiful(index):
            k = index + 1
            return nums[index] % k == 0 or k % nums[index] == 0

        def permutation(i):

            if i >= len(nums):
                # print(nums, i)
                next(output)
                return

            for j in range(i, len(nums)):
                nums[i], nums[j] = nums[j], nums[i]
                if isBeautiful(i):
                    permutation(i + 1)
                nums[i], nums[j] = nums[j], nums[i]

        permutation(0)
        return next(output)


if __name__ == "__main__":
    solution = Solution()
    output = solution.countArrangement(7)
    print(output)
