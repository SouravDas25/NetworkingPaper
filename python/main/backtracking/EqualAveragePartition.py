from typing import List


class Solution:
    # @param A : list of integers
    # @return a list of list of integers
    def avgset(self, array: List[int]):

        def recursion(i, totalSum, totalN, currentSum, currentN, currentSet):
            if i >= len(array):
                return False
            if totalSum * currentN == currentSum * totalN and currentSum != 0 and currentN != 0:
                print(currentSet)
                return True
            currentSet.append(array[i])
            b1 = recursion(i + 1, totalSum - array[i], totalN - 1, currentSum + array[i], currentN + 1, currentSet)
            currentSet.pop()
            b2 = recursion(i + 1, totalSum, totalN, currentSum, currentN, currentSet)

            return b1 or b2

        return recursion(0, sum(array), len(array), 0, 0, [])

        pass


if __name__ == "__main__":
    solution = Solution()
    output = solution.avgset([1, 7, 15, 29, 11, 9])
    print(output)
