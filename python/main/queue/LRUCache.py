from collections import deque


class LRUCache:

    def __init__(self, capacity: int):
        self.queue = []
        self.capacity = capacity
        self.cache = {}
        pass

    def __add_item(self, key, value):
        self.queue.append(key)
        self.cache[key] = value

    def __remove_item(self, key):
        value = self.cache.pop(key)
        self.queue.remove(key)
        return value

    def __move_to_end(self, key):
        self.queue.remove(key)
        self.queue.append(key)
        pass

    def get(self, key: int) -> int:
        if key not in self.cache:
            return -1
        self.__move_to_end(key)
        return self.cache[key]
        pass

    def put(self, key: int, value: int) -> None:
        if key in self.cache:
            self.cache[key] = value
            self.__move_to_end(key)
            pass
        else:
            if len(self.queue) == self.capacity:
                keyToRemove = self.queue[0]
                self.__remove_item(keyToRemove)
                self.__add_item(key, value)
                pass
            else:
                self.__add_item(key, value)
                pass
            pass
        pass


if __name__ == '__main__':
    cache = LRUCache(2)
    cache.put(1, 1)
    cache.put(2, 2)
    cache.put(3, 3)
    assert cache.get(1) == -1
