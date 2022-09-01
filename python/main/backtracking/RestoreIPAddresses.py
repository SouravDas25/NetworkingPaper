from typing import List


# https://leetcode.com/problems/restore-ip-addresses/
class Solution:

    def isValid(self, substr):
        if substr[0] == "0" and len(substr) > 1:
            return False
        return 0 <= int(substr) <= 255

    def dfs(self, i, s, current, output):
        if len(current) == 4 and i == len(s):
            output.append(".".join(current))
            return
        for j in range(i, min(i + 3, len(s))):
            substr = s[i:j + 1]
            if len(current) <= 4 and self.isValid(substr):
                # print(substr, current)
                current.append(substr)
                self.dfs(j + 1, s, current, output)
                current.pop()

    def restoreIpAddresses(self, s: str) -> List[str]:
        output = []
        self.dfs(0, s, [], output)
        return output


if __name__ == "__main__":
    sol = Solution()
    perms = sol.restoreIpAddresses("101023")
    print(perms)
