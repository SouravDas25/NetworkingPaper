from collections import deque


class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        stack = deque()
        removeIndex = set()
        for i in range(len(s)):
            if s[i] == "(":
                stack.append(i)
            elif s[i] == ")":
                if stack:
                    stack.pop()
                else:
                    removeIndex.add(i)
        newString = ""
        removeIndex.update(stack)
        for i in range(len(s)):
            if i in removeIndex:
                continue
            newString += s[i]
        return newString
        pass


if __name__ == "__main__":
    solution = Solution()
    output = solution.minRemoveToMakeValid("a(cd(ef")
    print(output)
