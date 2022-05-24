movement = [(-1, 0), (1, 0), (0, 1), (0, -1)]


def solve_dfs(board, i, j, visited, globalvisited):
    visited.add((i, j))
    globalvisited.add((i, j))
    elmInBorder = False
    for m in movement:
        xi, xj = i + m[0], j + m[1]
        if 0 <= xi < len(board) and 0 <= xj < len(board[i]):
            if board[xi][xj] == "O" and (xi, xj) not in visited:
                c = solve_dfs(board, xi, xj, visited, globalvisited)
                elmInBorder = elmInBorder or c
        else:
            elmInBorder = elmInBorder or True

    return elmInBorder


def solve(board) -> None:
    globalvisited = set()
    for i in range(len(board)):
        for j in range(len(board[i])):
            if board[i][j] == "O" and (i, j) not in globalvisited:
                visited = set()
                elementInBorder = solve_dfs(board, i, j, visited, globalvisited)
                print(elementInBorder, i, j)
                if not elementInBorder:
                    for ci, cj in visited:
                        board[ci][cj] = "X"


board = [
    ["X", "X", "X", "X"],
    ["X", "O", "O", "X"],
    ["X", "X", "O", "X"],
    ["X", "O", "X", "X"]
]

board = [["O", "O", "O"], ["O", "O", "O"], ["O", "O", "O"]]

solve(board)
board