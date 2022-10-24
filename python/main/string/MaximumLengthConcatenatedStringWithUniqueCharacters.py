from typing import List


class Solution:
    def maxLength(self, arr: List[str]) -> int:

        def dfs(i, concat):
            if i >= len(arr):
                return 0
            nc = concat + arr[i]
            maxLength = 0
            if len(set(nc)) == len(nc):
                maxLength = max(maxLength, dfs(i + 1, nc) + len(arr[i]))
            maxLength = max(maxLength, dfs(i + 1, concat))
            return maxLength

        return dfs(0, "")


if __name__ == "__main__":
    solution = Solution()
    output = solution.maxLength(["ab", "cd", "cde", "cdef", "efg", "fgh", "abxyz"])
    print(output)
