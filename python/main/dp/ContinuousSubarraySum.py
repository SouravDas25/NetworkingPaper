from typing import List


class Solution:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        hash_map = {0: 0}
        s = 0
        for i in range(len(nums)):
            s += nums[i]
            # if the remainder s % k occurs for the first time
            if s % k not in hash_map:
                hash_map[s % k] = i + 1
            # if the subarray size is at least two
            elif hash_map[s % k] < i:
                return True
            print(s, hash_map)
        return False


if __name__ == "__main__":
    solution = Solution()
    output = solution.checkSubarraySum([23, 2, 4, 6, 7], 6)
    print(output)
