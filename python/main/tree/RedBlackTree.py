class ColoredNode:

    def __init__(self, val=0, left=None, right=None, isBlack=True):
        self.val = val
        self.left = left
        self.right = right
        self.isBlack = isBlack

    def __repr__(self):
        return str(self.val)


class RedBlackTree:

    def __init__(self):
        self.root = None

    def insert(self, value):
        if self.root is None:
            pass
        else:
            pass

    def delete(self, value):
        pass

    def contains(self, value):
        pass

    def __contains__(self, item):
        return self.contains(item)
