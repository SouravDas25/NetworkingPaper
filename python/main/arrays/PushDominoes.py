class Solution:

    def solve(self, start, end, output):
        if output[start] == "." and output[end] == "R" or output[start] == "L" and output[end] == "." or output[
            start] == "L" and \
                output[end] == "R":
            return
        elif output[start] == "R" and output[end] == "L":
            k = 0
            length = abs(end - start) - 1
            while k < length // 2:
                output[start + k + 1] = "R"
                output[end - k - 1] = "L"
                k += 1
        elif output[start] == output[end]:
            val = output[end]
            for k in range(start, end + 1):
                output[k] = val
        elif output[start] == "R" and output[end] == "." or output[start] == "." and output[end] == "L":
            val = "R" if output[end] == "." else "L"
            for k in range(start, end + 1):
                output[k] = val

    def pushDominoes(self, dominoes: str) -> str:
        output = list(dominoes)
        prev = 0
        for i in range(1, len(dominoes)):
            if dominoes[i] in {"L", "R"}:
                self.solve(prev, i, output)
                prev = i
        self.solve(prev, len(dominoes) - 1, output)
        return "".join(output)


if __name__ == "__main__":
    solution = Solution()
    output = solution.pushDominoes("R.R.L")
    print(output)
