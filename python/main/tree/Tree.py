class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

    def __repr__(self):
        return str(self.val)


class Tree:
    @staticmethod
    def print(root: TreeNode):
        printNode("", root, False)

    @staticmethod
    def createTree(values) -> TreeNode:
        leafs = []
        num = values.pop(0)
        root = TreeNode(num)
        leafs.append(root)
        while len(values) > 0:
            node = leafs[0]
            if node.val is None:
                leafs.pop(0)
                continue

            if node.left is None:
                num = values.pop(0)
                node.left = TreeNode(num)
                leafs.append(node.left)
            elif node.right is None:
                num = values.pop(0)
                node.right = TreeNode(num)
                leafs.append(node.right)

            if node.right is not None and node.left is not None:
                leafs.pop(0)
                if node.right.val is None:
                    node.right = None
                if node.left.val is None:
                    node.left = None
        #         print(arr,leafs)
        #         printTree(root)
        return root


def printNode(prefix, node, isLeft):
    if node is not None:
        print(prefix + ("L-- " if isLeft else "R-- ") + str(node.val))
        printNode(prefix + ("|   " if isLeft else "    "), node.left, True)
        printNode(prefix + ("|   " if isLeft else "    "), node.right, False)


null = None

if __name__ == "__main__":
    tree = Tree.createTree(
        [5, 4, 5, 4, 4, 5, 3, 4, 4, null, null, null, 4, null, null, 4, null, null, 4, null, 4, 4, null, null, 4, 4])
    Tree.print(tree)
