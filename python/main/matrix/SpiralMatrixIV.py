from typing import Optional, List

import numpy as np

from main.linkedlist.LinkedList import ListNode, LinkedList
from main.matrix.SpiraIterator import SpiralIterator


class Solution:
    def spiralMatrix(self, m: int, n: int, head: Optional[ListNode]) -> List[List[int]]:
        matrix = [[0] * n for _ in range(m)]
        itr = SpiralIterator(m, n)
        while itr.hasNext():
            row, col = itr.next()
            matrix[row][col] = head.val if head is not None else -1
            if head is not None:
                head = head.next
        return matrix


if __name__ == "__main__":
    row = 3
    col = 5
    linkedList = LinkedList.create([3, 0, 2, 6, 8, 1, 7, 9, 4, 2, 5, 5, 0])
    solution = Solution()
    matrix = solution.spiralMatrix(row, col, linkedList)
    print(np.matrix(matrix))
