from typing import List


class Solution:
    def findSmallestSetOfVertices(self, n: int, edges: List[List[int]]) -> List[int]:
        inDegrees = [0] * n
        for a, b in edges:
            inDegrees[b] += 1
        output = []
        for i in range(n):
            if inDegrees[i] == 0:
                output.append(i)
        # print(inDegrees)
        return output


if __name__ == "__main__":
    solution = Solution()
    output = solution.findSmallestSetOfVertices(6, [[0, 1], [0, 2], [2, 5], [3, 4], [4, 2]])
    print(output)
