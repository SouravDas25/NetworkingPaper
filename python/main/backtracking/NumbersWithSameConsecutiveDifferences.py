from collections import deque
from typing import List


class Solution:
    def numsSameConsecDiff(self, n: int, k: int) -> List[int]:
        queue = deque(range(1, 10))
        level = 1
        while level < n and len(queue) > 0:
            loopTill = len(queue)
            for _ in range(loopTill):
                number = queue.popleft()
                lastDigit = number % 10
                if lastDigit + k < 10:
                    queue.append(number * 10 + lastDigit + k)
                if lastDigit - k >= 0 and k != 0:
                    queue.append(number * 10 + lastDigit - k)
            level += 1
        print(queue)
        return queue


if __name__ == "__main__":
    sol = Solution()
    output = sol.numsSameConsecDiff(2, 1)
    print(output)
