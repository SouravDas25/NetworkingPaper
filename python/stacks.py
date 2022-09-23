class MinStack:

    def __init__(self):
        self.vals = []
        self.min = []

    def push(self, val):
        self.vals.append(val)
        if len(self.min) <= 0 or val <= self.min[-1]:
            self.min.append(val)

    def pop(self):
        if len(self.min) > 0:
            val = self.vals.pop()
            if val == self.min[-1]:
                self.min.pop()
            return val
        return None

    def top(self):
        if len(self.min) > 0:
            return self.vals[-1]
        return None

    def getMin(self):
        return self.min[-1]


stack = MinStack()

stack.push(1)
stack.push(4)
stack.push(3)
stack.push(0)

print(stack.getMin())
stack.pop()
print(stack.getMin())
