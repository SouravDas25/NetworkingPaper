from collections import deque
from typing import List


class LockingTree:

    def __init__(self, parent: List[int]):
        self.parents = parent
        self.children = {i: [] for i in range(len(parent))}
        for i in range(1, len(parent)):
            self.children[parent[i]].append(i)

        self.locks = {}
        print(self.children)
        pass

    def isLocked(self, num):
        return num in self.locks

    def isUnlocked(self, num):
        return num not in self.locks

    def lock(self, num: int, user: int) -> bool:
        print("lock :", num, user)
        if self.isUnlocked(num):
            self.locks[num] = user
            return True
        else:
            return False
        pass

    def unlock(self, num: int, user: int, force=False) -> bool:
        print("unlock :", num, user)
        if self.isLocked(num) and (not force and self.locks[num] == user or force):
            self.locks.pop(num)
            return True
        else:
            return False
        pass

    def ancestors(self, node):
        ancestor = deque()
        while self.parents[node] != -1:
            ancestor.append(self.parents[node])
            node = self.parents[node]
        print("ancestor", ancestor)
        return ancestor

    def descendants(self, node):
        queue = deque(self.children[node])
        descendant = deque()
        while queue:
            node = queue.popleft()
            descendant.append(node)
            if self.children[node].__len__() > 0:
                queue.extend(self.children[node])
        print("descendant", descendant)
        return descendant

    def precheck(self, num, user):
        isDLockedCount = len(list(filter(lambda d: self.isLocked(d), self.descendants(num))))
        isALockedCount = len(list(filter(lambda d: self.isLocked(d), self.ancestors(num))))
        if self.isUnlocked(num) and isDLockedCount > 0 and isALockedCount < 1:
            return True
        else:
            return False

    def upgrade(self, num: int, user: int) -> bool:
        print("upgrade :", num, user)
        if self.precheck(num, user):
            self.lock(num, user)
            for d in self.descendants(num):
                self.unlock(d, user, force=True)
            return True
        else:
            return False
        pass


if __name__ == "__main__":
    solution = LockingTree([-1, 0, 0, 1, 1, 2, 2])
    print(solution.lock(2, 2))
    print(solution.unlock(2, 3))
    print(solution.unlock(2, 2))
    print(solution.lock(4, 5))
    print(solution.upgrade(0, 1))
    print(solution.lock(0, 1))
