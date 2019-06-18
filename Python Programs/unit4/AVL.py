from __future__ import print_function
# Python code to insert a node in AVL tree


class Node(object):
    def __init__(self):
        self.data = None
        self.left = None
        self.right = None
        self.height = 1


def Insert(root, element):
    if (root is None):
        return (GetNode(element))
    elif (element < root.data):
        root.lchild = Insert(root.lchild, element)
    else:
        root.rchild = Insert(root.rchild, element)
    # Update height of ancestor node
    root.height = FindMaximum(
        FindHeight(
            root.lchild), FindHeight(
            root.rchild)) + 1
    balance = GetBalance(root)
    # if the AVL tree is unbalanced , we check for 4 possible cases
    # LL type rotation
    if balance > 1 and element < root.lchild.data:
        print("LL type")
        return RightRotate(root)
    # RR type rotation
    if balance < -1 and element > root.rchild.data:
        print("RR type")
        return LeftRotate(root)
    # LR type rotation
    if (balance > 1 and element > root.lchild.data):
        print("\nLR type")
        root.lchild = LeftRotate(root.lchild)
        return RightRotate(root)
    # RL type rotation
    if (balance < -1 and element < root.rchild.data):
        print("\nRL type")
        root.rchild = RightRotate(root.rchild)
        return LeftRotate(root)

    return root


def GetNode(element):
    temp = Node()
    temp.data = element
    temp.height = 1
    temp.lchild = None
    temp.rchild = None
    return (temp)


def FindMaximum(node1_height, node2_height):
    if node1_height > node2_height:
        return (node1_height)
    else:
        return (node2_height)


def GetBalance(node1):
    if (node1 is None):
        return (0)
    else:
        return (FindHeight(node1.lchild) - FindHeight(node1.rchild))


def LeftRotate(lchildRoot):
    temp1 = lchildRoot.rchild
    temp2 = temp1.lchild
    temp1.lchild = lchildRoot
    lchildRoot.rchild = temp2
    lchildRoot.height = FindMaximum(
        FindHeight(
            lchildRoot.lchild), FindHeight(
            lchildRoot.rchild)) + 1
    temp1.height = FindMaximum(
        FindHeight(
            temp1.lchild), FindHeight(
            temp1.rchild)) + 1
    return temp1


def RightRotate(rightRoot):
    temp1 = rightRoot.lchild
    temp2 = temp1.rchild

    temp1.rchild = rightRoot
    rightRoot.lchild = temp2
    rightRoot.height = FindMaximum(
        FindHeight(
            rightRoot.lchild), FindHeight(
            rightRoot.rchild)) + 1
    temp1.height = FindMaximum(
        FindHeight(
            temp1.lchild), FindHeight(
            temp1.rchild)) + 1
    return temp1


def inorder(root):
    if root is not None:
        inorder(root.lchild)
        print(root.data, root.height)
        inorder(root.rchild)


def FindHeight(node1):
    if node1 is None:
        return 0
    else:
        return node1.height


def InorderSuccessor(inorder_N):
    while inorder_N.lchild is not None:
        # parent_inorder_N = inorder_N
        inorder_N = inorder_N.lchild

    return (inorder_N)


def Delete_LinkedList_AVL(root, element):
    if root is None:
        return root

    if element < root.data:  # # Is the node the lchild or right child of the root
        root.lchild = Delete_LinkedList_AVL(root.lchild, element)

    elif element > root.data:
        root.rchild = Delete_LinkedList_AVL(root.rchild, element)

    else:  # The element is found
        # Case 1 - Delete leaf node or Case 2 - Delete node with one child
        if (root.lchild is None) or (root.rchild is None):
            if root.lchild is not None:  # Is the child in the eft of the root
                temp = root.lchild
            else:
                temp = root.rchild
            if temp is None:  # Case 1 - Delete leaf node
                temp = root
                root = None
            else:  # Case 2 - Delete node with one child
                root = temp  # Copy the contents of the non-empty child

        else:
            # Case 3 - Delete node with 2 children
            temp = InorderSuccessor(root.rchild)

        # Copy the inorder successor's data to this node
        root.data = temp.data

        # Delete the inorder successor
        root.rchild = Delete_LinkedList_AVL(root.rchild, temp.data)

    # If the tree had only one node then return
    if root is None:
        return root

    # Update height of current node
    root.height = FindMaximum(
        FindHeight(
            root.lchild), FindHeight(
            root.rchild)) + 1

    balance = GetBalance(root)

    # If this node becomes unbalanced, then there are 4 cases, combining R0
    # and R1 and L0 nd L-1 respectively

    # R0 or R1 rotation
    if balance > 1 and GetBalance(root.lchild) >= 0:
        print("Right Rotate")
        return RightRotate(root)

    # R-1 Rotation
    if balance > 1 and GetBalance(root.lchild) < 0:
        print("R-1 rotation")
        root.lchild = LeftRotate(root.lchild)
        return RightRotate(root)

    # L0 and L-1 Rotation
    if balance < -1 and GetBalance(root.rchild) <= 0:
        print("Left Rotate")
        return LeftRotate(root)

    # L1 Rotation
    if balance < -1 and GetBalance(root.rchild) > 0:
        print("L1 rotation")
        root.rchild = RightRotate(root.rchild)
        return LeftRotate(root)

    return root


root = None
# clrscr()
while True:

    choice = int(
        input("\n1. Insert\n2. Delete\n3. Inorder\n4.Exit\nChoice : "))

    if choice == 1:
        arr = raw_input(
            "\nEnter the elements to enter with space : ").split(" ")
        for element in arr:
            root = Insert(root, int(element))
            inorder(root)

    elif choice == 2:
        element = int(input("Enter element to delete : "))
        root = Delete_LinkedList_AVL(root, element)
        inorder(root)

    elif choice == 3:
        inorder(root)

    elif choice == 4:
        exit(0)
    else:
        print("Wrong Choice")
