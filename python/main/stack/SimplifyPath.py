from collections import deque


class Solution:
    def simplifyPath(self, path: str) -> str:
        split = path.split("/")
        split = filter(lambda x: len(x) > 0, split)
        split = list(split)
        print(split)
        stack = deque()
        for path in split:
            if path == "..":
                if len(stack) > 0:
                    stack.pop()
            elif path == ".":
                pass
            else:
                stack.append(path)
        return "/" + "/".join(stack)


if __name__ == "__main__":
    sol = Solution()
    sp = sol.simplifyPath("/home//foo/")
    print(sp)
