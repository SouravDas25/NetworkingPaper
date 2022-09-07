from typing import Tuple, List

import numpy as np


class SpiralIterator:

    def __init__(self, rows: int, columns: int):
        self.rows = rows
        self.columns = columns
        self.started = False
        self.current: Tuple[int, int] = 0, 0
        self.lengths = rows, columns
        self.starts = 0, 0
        self.accessItems = 0

    def lastColumnIndex(self):
        return self.starts[1] + self.lengths[1] - 1

    def firstColumnIndex(self):
        return self.starts[1]

    def lastRowIndex(self):
        return self.starts[0] + self.lengths[0] - 1

    def firstRowIndex(self):
        return self.starts[0]

    def hasNext(self):
        if self.accessItems < self.rows * self.columns:
            return True
        return False

    def next(self) -> Tuple[int, int]:
        if self.started:
            row, col = self.current

            if row == self.firstRowIndex() + 1 and col == self.firstColumnIndex() or \
                    self.firstRowIndex() == self.lastRowIndex() and col == self.lastColumnIndex():
                self.starts = self.starts[0] + 1, self.starts[1] + 1
                self.lengths = self.lengths[0] - 2, self.lengths[1] - 2
                self.current = self.starts[0], self.starts[1]
            elif self.lengths[1] == 1:
                self.current = self.current[0] + 1, self.current[1]
            elif self.lengths[0] == 1:
                self.current = self.current[0], self.current[1] + 1
            elif row == self.firstRowIndex() and self.firstColumnIndex() <= col < self.lastColumnIndex():
                self.current = self.current[0], self.current[1] + 1
            elif col == self.lastColumnIndex() and self.firstRowIndex() <= row < self.lastRowIndex():
                self.current = self.current[0] + 1, self.current[1]
            elif row == self.lastRowIndex() and self.firstColumnIndex() < col <= self.lastColumnIndex():
                self.current = self.current[0], self.current[1] - 1
            elif col == self.firstColumnIndex() and self.firstRowIndex() < row <= self.lastRowIndex():
                self.current = self.current[0] - 1, self.current[1]
            print((row, col), self.current)
        else:
            self.started = True
        self.accessItems += 1
        return self.current


if __name__ == "__main__":
    row = 10
    col = 1
    matrix = [[0] * col for _ in range(row)]
    count = 1
    itr = SpiralIterator(row, col)
    while itr.hasNext():
        row, col = itr.next()
        matrix[row][col] = count
        count += 1
    print(np.matrix(matrix))
