class Solution:
    def longestPalindrome(self, s: str) -> str:
        dp = [[False] * len(s) for _ in range(len(s))]
        for i in range(len(s)):
            dp[i][i] = True

        ans = s[0]
        for i in range(len(s) - 1, -1, -1):
            for j in range(i + 1, len(s)):
                if s[i] == s[j]:
                    if i + 1 == j or dp[i + 1][j - 1]:
                        dp[i][j] = True
                        ca = s[i:j + 1]
                        if len(ca) > len(ans):
                            ans = ca
        return ans
        pass


if __name__ == '__main__':
    s = Solution()
    print(s.longestPalindrome("cbba"))
