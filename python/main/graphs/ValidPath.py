import math


class Solution:
    MOVEMENTS = [(1, 0), (-1, 0), (0, 1), (0, -1), (-1, -1), (1, -1), (1, 1), (-1, 1)]

    CACHE = {}

    def dist(self, p, q):
        return math.sqrt(sum((px - qx) ** 2.0 for px, qx in zip(p, q)))

    def isSafeFromCircle(self, p1, cicles, R):
        if p1 in Solution.CACHE:
            return Solution.CACHE[p1]
        for center in cicles:
            if self.dist(center, p1) <= R:
                Solution.CACHE[p1] = False
                return False
        Solution.CACHE[p1] = True
        return True

    def solve(self, xlim, ylim, n, R, xes, yes):
        Solution.CACHE.clear()
        stack = [(0, 0)]
        visited = set()
        circles = list(zip(xes, yes))
        print(circles)
        while len(stack) > 0:
            x, y = stack.pop()
            visited.add((x, y))
            if x == xlim and y == ylim:
                return "YES"
            for dx, dy in Solution.MOVEMENTS:
                nx = x + dx
                ny = y + dy
                if 0 <= nx <= xlim and 0 <= ny <= ylim and (nx, ny) not in visited \
                        and self.isSafeFromCircle((nx, ny), circles, R):
                    stack.append((nx, ny))
        return "NO"
        pass


if __name__ == "__main__":
    solution = Solution()
    output = solution.solve(7, 91, 8, 7, [1, 7, 1, 7, 1, 5, 1, 6], [25, 4, 74, 14, 90, 58, 37, 4])
    print(output)
