class Solution:
    def longestValidParentheses(self, s: str) -> int:
        stack = []
        dp = [0] * (len(s) + 1)
        for i in range(len(s)):
            if s[i] == "(":
                stack.append(i)
            else:
                if stack:
                    j = stack.pop()
                    dp[i] = i - j + 1 + dp[j - 1]
        # print(dp)
        return max(dp)


if __name__ == "__main__":
    solution = Solution()
    area = solution.longestValidParentheses(")()())")
    print(area)
