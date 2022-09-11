class Solution:
    def minCut(self, s: str) -> int:
        output = []
        partitions = []
        def rec(i):
            if i >= len(s):
                output.append(len(partitions))
            for j in range(i, len(s)):
                if isPalindrome(s, i, j):
                    partitions.append(s[i:j+1])
                    rec(j+1)
                    partitions.pop()
        rec(0)
        return min(output) - 1


def isPalindrome(s, start, end):
    length = end - start + 1
    for i in range(0, (length)//2):
        if s[start+i] != s[end-i]:
            return False
    return True


if __name__ == "__main__":
    solution = Solution()
    output = solution.minCut("aab")
    print(output)
