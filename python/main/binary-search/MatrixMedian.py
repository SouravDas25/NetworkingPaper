from bisect import bisect_right


class Solution:
    # @param A : list of list of integers
    # @return an integer
    def findMedian(self, matrix):
        totalCount = 0
        mi = matrix[0][0]
        ma = 0
        for i in range(len(matrix)):
            mi = min(matrix[i][0], mi)
            ma = max(matrix[i][-1], ma)
            totalCount += len(matrix[i])

        desired = (totalCount + 1) // 2

        while mi < ma:
            mid = (mi + ma) // 2
            lc = 0
            for i in range(len(matrix)):
                j = bisect_right(matrix[i], mid)
                lc += j
            if lc < desired:
                mi = mid + 1
            else:
                ma = mid
        return mi
        pass


if __name__ == "__main__":
    solution = Solution()
    m = [[1, 3], [2], [1, 2, 3, 4, 5, 5, 6, 7]]
    output = solution.findMedian(m)
    print(output)
