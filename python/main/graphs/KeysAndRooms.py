from collections import deque
from typing import List


class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        visited = {0}
        queue = deque([0])
        while len(queue) > 0:
            size = len(queue)
            for _ in range(size):
                node = queue.popleft()
                for key in rooms[node]:
                    if key not in visited:
                        visited.add(key)
                        queue.append(key)
        print(visited)
        return len(visited) == len(rooms)
        pass


if __name__ == "__main__":
    solution = Solution()
    output = solution.canVisitAllRooms([[1,3],[3,0,1],[2],[0]])
    print(output)
