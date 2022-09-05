from collections import defaultdict, deque
from typing import List


class Solution:

    # @lru_cache
    def isDifferenceOne(self, word1, word2):
        count = 0
        for i in range(len(word1)):
            if word1[i] != word2[i]:
                count += 1
            if count > 1:
                return False
        return count <= 1

    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        wordList.append(beginWord)

        wordSet = set(wordList)
        if endWord not in wordSet:
            return 0

        graph = defaultdict(set)
        for word1 in wordList:
            for word2 in wordList:
                if word1 != word2 and self.isDifferenceOne(word1, word2):
                    graph[word1].add(word2)
                    graph[word2].add(word1)

        print(graph)
        queue = deque([beginWord])
        level = 0
        visited = set()
        while len(queue) > 0:
            level += 1
            size = len(queue)
            for i in range(size):
                word = queue.popleft()
                visited.add(word)
                if word == endWord:
                    return level

                for vertex in graph[word]:
                    if vertex not in visited:
                        queue.append(vertex)
                        if word == endWord:
                            return level + 1
        return 0


if __name__ == "__main__":
    solution = Solution()
    output = solution.ladderLength("hit", "cog", ["hot", "dot", "dog", "lot", "log", "cog"])
    print(output)
