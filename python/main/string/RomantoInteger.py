romanToInt = {
    'I': 1,
    'V': 5,
    'X': 10,
    'L': 50,
    'C': 100,
    'D': 500,
    'M': 1000,
    'F': 5000,
    'G': 10000,
    'P': 10000
}


class Solution:
    def romanToInt(self, s: str) -> int:
        amount = 0
        i = 0
        while i < len(s):
            value = romanToInt[s[i]]
            nextValue = romanToInt[s[i + 1]] if i + 1 < len(s) else 0
            if nextValue > value:
                amount += nextValue - value
                i += 1
            else:
                amount += value
                pass

            i += 1
        return amount
        pass


if __name__ == '__main__':
    s = Solution()
    print(s.romanToInt('MCMXCIV'))
