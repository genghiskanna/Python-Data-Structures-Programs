# Preorder traversal of a tree represented using arrays

# Tree is the array holding the tree of size N.
# root is the index of the array indicating the beginning of the Tree or the Subtree.
# The empty positions in an array are denoted by 0. So it is a tree of
# non-zero elements.

from __future__ import print_function


def Preorder(TREE, root):
    N = len(TREE)
    print("%d\t" % (TREE[root]))
    try:
        if (TREE[(2 * root) + 1]) != 0 and 2 * \
                root + 1 < N:  # Does a left child exist?
            Preorder(TREE, 2 * root + 1)
        if (TREE[(2 * root) + 2]) != 0 and 2 * \
                root + 2 < N:  # Does a right child exist?
            Preorder(TREE, 2 * root + 2)
    except IndexError:
        pass



# Creating the tree
# replace raw_input with input if Python3
TREE = [int(x) for x in raw_input(
    "Enter the Elements of the tree separated by space: \n").split(" ")]
print("\nPreorder traversal of tree:")
Preorder(TREE, 0)
