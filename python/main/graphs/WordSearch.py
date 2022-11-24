from typing import List

MOVEMENTS = [(1, 0), (0, 1), (-1, 0), (0, -1)]


class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        visited = set()

        def dfs(i, j, wi):
            if wi >= len(word):
                return True
            visited.add((i, j))
            for di, dj in MOVEMENTS:
                ni = i + di
                nj = j + dj
                if 0 <= ni < len(board) and 0 <= nj < len(board[ni]):
                    if (ni, nj) not in visited and word[wi] == board[ni][nj]:
                        if dfs(ni, nj, wi + 1):
                            return True
            visited.remove((i, j))
            return False

        for i in range(len(board)):
            for j in range(len(board[i])):
                if board[i][j] == word[0]:
                    if dfs(i, j, 1):
                        return True
        return False

        pass


if __name__ == "__main__":
    solution = Solution()
    output = solution.exist([["C", "A", "A"], ["A", "A", "A"], ["B", "C", "D"]], "AAB")
    print(output)
