from unittest import TestCase

from main.tree.ConvertSortedArrayBinarySearchTree import ConvertSortedArray2BinarySearchTree
from main.tree.Tree import printTree


class Test(TestCase):

    def test_convert_sorted_array_2_binary_search_tree(self):
        cs = ConvertSortedArray2BinarySearchTree()
        tree = cs.sortedArrayToBST([-10, -3, 0, 5, 9])
        printTree(tree)
