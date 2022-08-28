class Solution:

    def compile(self, s):
        pattern = []
        for i, ch in enumerate(s):
            if ch == '*':
                pattern[-1][1] = True
            else:
                pattern.append([ch, False])
        return pattern

    def isMatch(self, s: str, p: str) -> bool:
        pattern = self.compile(p)
        print(pattern)
        S_LEN = len(s)
        P_LEN = len(pattern)

        dp = [[False] * (S_LEN + 1) for _ in range(P_LEN + 1)]
        dp[-1][-1] = True

        for i in range(P_LEN - 1, -1, -1):
            dp[i][-1] = pattern[i][1] and dp[i + 1][-1]

        for i in range(P_LEN - 1, -1, -1):
            ch, isStar = pattern[i]
            for j in range(S_LEN - 1, -1, -1):
                if isStar:
                    if ch == s[j] or ch == ".":
                        dp[i][j] = dp[i + 1][j] or dp[i][j + 1]
                    else:
                        dp[i][j] = dp[i + 1][j]
                    pass
                else:
                    if ch == s[j] or ch == ".":
                        dp[i][j] = dp[i + 1][j + 1]
                    else:
                        dp[i][j] = False

        for row in dp:
            print(row)

        return dp[0][0]


if __name__ == "__main__":
    sol = Solution()
    b = sol.isMatch("aabcbcbcaccbcaabc", ".*a*aa*.*b*.c*.*a*")
    print(b)
