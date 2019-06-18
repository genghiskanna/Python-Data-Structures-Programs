from __future__ import print_function


class Node:

    def __init__(self, key):
        self.key = key
        self.left = None
        self.right = None


# A utility function to do inorder traversal of BST
def inorder(root):
    if root is not None:
        inorder(root.left)
        print(root.key, end=" ")
        inorder(root.right)


# A utility function to insert a new node with given key in BST
def insert(node, key):
    # If the tree is empty, return a new node
    if node is None:
        return Node(key)

    # Otherwise recur down the tree
    if key < node.key:
        node.left = insert(node.left, key)
    else:
        node.right = insert(node.right, key)

    # return the (unchanged) node pointer
    return node


# Given a non-empty binary search tree, return the node
# with minum key value found in that tree. Note that the
# entire tree does not need to be searched
def minValueNode(node):
    current = node

    # loop down to find the leftmost leaf
    while (current.left is not None):
        current = current.left

    return current


def search(root, key):
    # Base Cases: root is null or key is present at root
    if root is None or root.key == key:
        return root

    # Key is greater than root's key
    if root.key < key:
        return search(root.right, key)

    # Key is smaller than root's key
    return search(root.left, key)


root = None
while True:
    c = int(input("\n1.Insert\n2.Search\n3.Display\n4.Exit\nChoice : "))
    if c == 1:
        num = int(input("\nEnter the number to insert : "))
        root = insert(root, num)
    elif c == 2:
        num = int(input("\nEnter the number to Search : "))
        temp = search(root, num)
        if temp is None:
            print("Not Found")
        else:
            print("%d found" % temp.key)
    elif c == 3:
        inorder(root)
    elif c == 4:
        exit(0)
    else:
        print("Wrong Choice")
