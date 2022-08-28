# https://leetcode.com/problems/integer-to-roman/

FACTORS = [
    # 100_000,
    # 50_000,
    # 10_000,
    # 5000,
    1000,
    500,
    100,
    50,
    10,
    5,
    1
]
ROMAN_NUMBERS = {
    # 100_000: "Q",
    # 50_000: "W",
    # 10000: "Y",
    # 5000: "Z",
    1000: "M",
    500: "D",
    100: "C",
    50: "L",
    10: "X",
    5: "V",
    1: "I"
}
SUB_FACTOR = {
    # 100_000: 10000,
    # 50_000: 10000,
    # 10000: 1000,
    # 5000: 1000,
    1000: 100,
    500: 100,
    100: 10,
    50: 10,
    10: 1,
    5: 1
}


class Solution:

    def intToRoman(self, num: int) -> str:
        output = []
        while num > 0:
            for factor in FACTORS:
                if num >= factor:
                    count = max(num // factor, 0)
                    num = num % factor
                    output.append(ROMAN_NUMBERS[factor] * count)
                    break

                if factor in SUB_FACTOR:
                    subFactor = SUB_FACTOR[factor]
                    if num - (num % subFactor) == factor - subFactor:
                        num = num % (factor - subFactor)
                        output.append(ROMAN_NUMBERS[subFactor] + ROMAN_NUMBERS[factor])
                        break
        # print(output)
        return "".join(output)

        pass


if __name__ == "__main__":
    s = Solution()
    for i in range(1, 100):
        roman = s.intToRoman(i)
        print(i, "-", roman)
