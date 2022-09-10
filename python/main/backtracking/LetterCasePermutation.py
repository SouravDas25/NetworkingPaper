from typing import List


class Solution:
    def letterCasePermutation(self, s: str) -> List[str]:

        output = []

        def recursion(i, permutedString: List[str]):
            if i >= len(s):
                output.append("".join(permutedString))
                return
            # print(permutedString)
            recursion(i + 1, permutedString)

            if permutedString[i].isalpha():
                permutedString[i] = permutedString[i].swapcase()
                recursion(i + 1, permutedString)
                permutedString[i] = permutedString[i].swapcase()

        recursion(0, list(s))
        return output


if __name__ == "__main__":
    solution = Solution()
    output = solution.letterCasePermutation("3z4")
    print(output)
