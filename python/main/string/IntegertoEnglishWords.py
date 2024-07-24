NUMS = {
    0: "Zero",
    1: "One",
    2: "Two",
    3: "Three",
    4: "Four",
    5: "Five",
    6: "Six",
    7: "Seven",
    8: "Eight",
    9: "Nine",
    10: "Ten",
    11: "Eleven",
    12: "Twelve",
    13: "Thirteen",
    14: "Fourteen",
    15: "Fifteen",
    16: "Sixteen",
    17: "Seventeen",
    18: "Eighteen",
    19: "Nineteen",
    20: "Twenty",
    30: "Thirty",
    40: "Forty",
    50: "Fifty",
    60: "Sixty",
    70: "Seventy",
    80: "Eighty",
    90: "Ninety",
}

units = {
    1_000: "Thousand",
    1_000_000: "Million",
    1_000_000_000: "Billion",
    1_000_000_000_000: "Trillion",
}


class Solution:

    def convert2D(self, num):
        if num in NUMS:
            return NUMS[num]
        d10, d1 = (num // 10) * 10, num % 10
        return f"{NUMS[d10]} {NUMS[d1]}"
        pass

    def convert3D(self, num):
        if num < 100:
            return self.convert2D(num)
        d100, drest = (num // 100), num % 100
        if drest == 0:
            return self.convert2D(d100) + " Hundred"
        else:
            return self.convert2D(d100) + " Hundred " + self.convert2D(drest)
        pass

    def convert(self, num):
        if num < 1000:
            return self.convert3D(num)
        ul = list(sorted(units.keys(), reverse=True))
        output = []
        for unit in ul:
            unit_txt = units[unit]
            if num < unit:
                continue
            d100 = num // unit
            num = num % unit
            output.append(f"{self.convert3D(d100)} {unit_txt}")

        if 0 < num < 1000:
            output.append(f"{self.convert3D(num)}")

        return " ".join(output)

    def numberToWords(self, num: int) -> str:
        return self.convert(num)
        pass


if __name__ == '__main__':
    s = Solution()
    # for i in range(10000, 20001):
    #     print(i, s.numberToWords(i))
    # print(s.numberToWords(1_000_000_101))
    print(s.numberToWords(1_111_111_111))
