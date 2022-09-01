from typing import List


class Solution:

    def dfs(self, i, nums, output):
        if i >= len(nums):
            output.add(tuple(nums))
            return

        for j in range(i, len(nums)):
            if j > i and nums[j] == nums[j - 1]:
                continue
            nums[i], nums[j] = nums[j], nums[i]
            self.dfs(i + 1, nums, output)
            nums[i], nums[j] = nums[j], nums[i]

    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        output = set()
        nums.sort()
        self.dfs(0, nums, output)
        return output
        pass


if __name__ == "__main__":
    sol = Solution()
    perms = sol.permuteUnique([0, 0, 0, 1, 2])
    print(perms)
