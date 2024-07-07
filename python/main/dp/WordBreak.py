from typing import List


class Solution:

    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        dp = [False] * (len(s) + 1)
        dp[-1] = True
        wordDict = set(wordDict)
        for i in range(len(s), -1, -1):
            for w in wordDict:
                substr = s[i:i + len(w)]
                if substr in wordDict and dp[i + len(substr)] == True:
                    # print(substr)
                    dp[i] = True
        return dp[0]


if __name__ == "__main__":
    solution = Solution()
    output = solution.wordBreak("applepenapple", ["apple", "pen"])
    print(output)
