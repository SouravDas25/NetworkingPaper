from typing import List


class Solution:

    def dfs(self, i, s, current, output):
        if len(current) > 4 :
            return
        for j in range(len(s)):
            substr = s[i:j + 1]



    def restoreIpAddresses(self, s: str) -> List[str]:


if __name__ == "__main__":
    sol = Solution()
    perms = sol.restoreIpAddresses("25525511135")
    print(perms)
