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


def deleteNode(root, key):
    # Base Case
    if root is None:
        return root

    # If the key is similiar lies in  left subtree
    if key < root.key:
        root.left = deleteNode(root.left, key)

    # If the key is similiar lies in  right subtree
    elif (key > root.key):
        root.right = deleteNode(root.right, key)

    # If key is same as root's key, then this is the node to be deleted
    else:
        # Node with only one child or no child
        if root.left is None:
            temp = root.right
            root = None
            return temp
        elif root.right is None:
            temp = root.left
            root = None
            return temp

        # Node with two children: Get the inorder successor
        # (smallest in the right subtree)
        temp = minValueNode(root.right)

        # Copy the inorder successor's content to this node
        root.key = temp.key

        # Delete the inorder successor
        root.right = deleteNode(root.right, temp.key)

    return root


root = None
while True:
    c = int(input("\n1.Insert\n2.Delete\n3.Display\n4.Exit\nChoice : "))
    if c == 1:
        num = int(input("\nEnter the number to insert : "))
        root = insert(root, num)
    elif c == 2:
        num = int(input("\nEnter the number to Delete : "))
        deleteNode(root, num)
    elif c == 3:
        inorder(root)
    elif c == 4:
        exit(0)
    else:
        print("Wrong Choice")
