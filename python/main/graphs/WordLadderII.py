from collections import defaultdict, deque
from functools import lru_cache
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

    def findLadders(self, beginWord: str, endWord: str, wordList: List[str]) -> List[List[str]]:
        wordList.append(beginWord)
        graph = defaultdict(set)
        for word1 in wordList:
            for word2 in wordList:
                if word1 != word2 and self.isDifferenceOne(word1, word2):
                    graph[word1].add(word2)
                    graph[word2].add(word1)

        print(graph)
        queue = deque([(beginWord, [beginWord])])
        output = []
        endWordReached = False
        visited = set()
        while len(queue) > 0:
            size = len(queue)
            for i in range(size):
                word, current = queue.popleft()
                visited.add(word)
                if word == endWord:
                    output.append(current)
                    endWordReached = True

                for vetex in graph[word]:
                    if vetex not in visited:
                        queue.append((vetex, current + [vetex]))
            if endWordReached:
                return output
        return output


if __name__ == "__main__":
    solution = Solution()
    output = solution.findLadders("hit", "cog",["hot","dot","dog","lot","log","cog"])
    print(output)
