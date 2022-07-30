class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

    def __repr__(self):
        return str(self.val)


def printNode(prefix, node, isLeft):
    if node is not None:
        print(prefix + ("|-- " if isLeft else "+-- ") + str(node.val))
        printNode(prefix + ("|   " if isLeft else "    "), node.left, True)
        printNode(prefix + ("|   " if isLeft else "    "), node.right, False)


def printTree(root):
    printNode("", root, False)


def generateTree(arr):
    leafs = []
    num = arr.pop(0)
    root = TreeNode(num)
    leafs.append(root)
    while len(arr) > 0:
        node = leafs[0]
        if node.data == None:
            leafs.pop(0)
            continue

        if node.left is None:
            num = arr.pop(0)
            node.left = TreeNode(num)
            leafs.append(node.left)
        elif node.right is None:
            num = arr.pop(0)
            node.right = TreeNode(num)
            leafs.append(node.right)

        if node.right is not None and node.left is not None:
            leafs.pop(0)
            if node.right.data == None:
                node.right = None
            if node.left.data == None:
                node.left = None
    #         print(arr,leafs)
    #         printTree(root)
    return root


null = None
