import heapq
from typing import List


class Solution:
    def candy(self, ratings: List[int]) -> int:
        candies = [1] * len(ratings)
        minHeap = []
        for i in range(len(ratings)):
            heapq.heappush(minHeap, (ratings[i], i))

        while len(minHeap) > 0:
            rating, i = heapq.heappop(minHeap)
            leftCount = 0
            rightCount = 0
            leftRating = ratings[i - 1] if i > 0 else 0
            rightRating = ratings[i + 1] if i < len(ratings) - 1 else 0
            if rating > leftRating:
                leftCount = candies[i - 1] if i > 0 else 0
            if rating > rightRating:
                rightCount = candies[i + 1] if i < len(ratings) - 1 else 0

            candies[i] = max(leftCount, rightCount) + candies[i]

        return sum(candies)

        pass


if __name__ == '__main__':
    solution = Solution()
    ans = solution.candy([1, 0, 2])
    print(ans)
