from collections import deque


class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        stack = deque()

        for i in range(len(s)):
            if s[i] == "(":
                stack.append(s[i])
        pass


if __name__ == "__main__":
    solution = Solution()
    output = solution.minRemoveToMakeValid("lee(t(c)o)de)")
    print(output)
