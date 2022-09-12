class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        splits = s.split(" ")
        if len(splits) != len(pattern):
            return False

        stringSet = list(dict.fromkeys(splits).keys())
        patternSet = list(dict.fromkeys(pattern).keys())
        if len(stringSet) != len(patternSet):
            return False

        patternMapping = {}
        for i in range(len(patternSet)):
            if stringSet[i] not in patternMapping:
                patternMapping[stringSet[i]] = patternSet[i]
            else:
                if patternMapping[stringSet[i]] != patternSet[i]:
                    return False
        print(patternMapping)

        for i in range(len(pattern)):
            if patternMapping[splits[i]] != pattern[i]:
                return False

        return True


if __name__ == "__main__":
    solution = Solution()
    output = solution.wordPattern("aaaa", "dog cat cat dog")
    print(output)
