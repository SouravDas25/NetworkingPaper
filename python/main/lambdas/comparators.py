from typing import Callable, TypeVar

Comparable = TypeVar('sortObject')


def naturalOrder(x: Comparable, y: Comparable):
    if x < y:
        return -1
    elif y < x:
        return 1
    else:
        return 0


def reverseOrder(compareFunction: Callable[[Comparable, Comparable], int]):
    return lambda x, y: - compareFunction(x, y)
