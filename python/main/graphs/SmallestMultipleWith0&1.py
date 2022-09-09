class Solution:
    # @param A : integer
    # @return a strings
    def multiple(self, n):
        queue = []

        # set of visited remainders
        visitedRem = set([])
        t = '1'
        queue.append(t)
        while queue:
            t = queue.pop(0)
            rem = int(t) % n
            if rem == 0:
                return t
            if rem not in visitedRem:
                visitedRem.add(rem)
                queue.append(t + '0')
                queue.append(t + '1')


if __name__ == "__main__":
    s = Solution()
    output = s.multiple(2)
    print(output)
