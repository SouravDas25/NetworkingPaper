POSSIBLE_MOVES = {
    0: [6, 4],
    1: [6, 8],
    2: [7, 9],
    3: [4, 8],
    4: [3, 9, 0],
    5: [],
    6: [1, 7, 0],
    7: [2, 6],
    8: [1, 3],
    9: [2, 4],
}

CACHE = [0] * 5001
IND = [1] * 10
CACHE[1] = 10
LAST_SAVED = 1

MODULO_9 = 10 ** 9 + 7


class Solution:
    def knightDialer(self, N: int) -> int:
        global IND, LAST_SAVED
        for n in range(LAST_SAVED + 1, N + 1):
            newIND = [0] * 10
            for i in range(10):
                for move in POSSIBLE_MOVES[i]:
                    newIND[i] += IND[move]
            CACHE[n] = sum(newIND) % MODULO_9
            # print(newIND, n, CACHE[n])
            IND = newIND
        LAST_SAVED = max(LAST_SAVED, N)
        return CACHE[N]


if __name__ == "__main__":
    solution = Solution()
    output = solution.knightDialer(4)
    print(output)
