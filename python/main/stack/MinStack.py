class MinStack:

    def __init__(self):
        self.stack = []
        self.mins = []
        pass

    def push(self, val: int) -> None:
        self.stack.append(val)
        if len(self.mins) == 0:
            self.mins.append(val)
        else:
            if val <= self.mins[-1]:
                self.mins.append(val)
        pass

    def pop(self) -> None:
        top = self.stack.pop()
        if len(self.mins) > 0 and top == self.mins[-1]:
            self.mins.pop()
        pass

    def top(self) -> int:
        return self.stack[-1]
        pass

    def getMin(self) -> int:
        return self.mins[-1]
        pass


if __name__ == "__main__":
    s = MinStack()
    s.push(-2)
    s.push(0)
    s.push(-3)
    assert s.getMin() == -3
    s.pop()
    assert s.top() == 0
    assert s.getMin() == -2