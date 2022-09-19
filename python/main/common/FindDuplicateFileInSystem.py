import re
from collections import defaultdict
from typing import List


class Solution:
    def findDuplicate(self, paths: List[str]) -> List[List[str]]:
        files = []
        for item in paths:
            splits = item.split(" ")
            for i in range(1, len(splits)):
                matches = re.match(r'^(.+\..+)\((.*)\)$', splits[i])
                files.append({
                    "path": splits[0],
                    "filename": matches.group(1),
                    "content": matches.group(2),
                })
        seen = defaultdict(list)
        duplicates = []
        for file in files:
            seen[file["content"]].append(file["path"] + "/" + file["filename"])
            if len(seen[file["content"]]) == 2:
                duplicates.append(seen[file["content"]])
        print(seen)
        return duplicates


if __name__ == "__main__":
    solution = Solution()
    output = solution.findDuplicate(
        ["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"])
    print(output)
