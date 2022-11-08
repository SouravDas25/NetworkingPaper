from typing import List


class Solution:
    def findMaxForm(self, strs: List[str], m: int, n: int) -> int:
        dict_ = {(0, 0): 0}
        res = 0
        for ind in range(len(strs)):
            n0 = strs[ind].count('0')
            n1 = strs[ind].count('1')
            for (k0, k1), val in list(dict_.items()):
                key = (n0 + k0, n1 + k1)
                if key[0] > m or key[1] > n:
                    continue
                ref = dict_[key] if key in dict_ else 0
                dict_[key] = max(val+1, ref)
                res = max(res, dict_[key])
        return res


if __name__ == "__main__":
    solution = Solution()
    output = solution.findMaxForm(["10", "0001", "111001", "1", "0"], 5, 3)
    print(output)
