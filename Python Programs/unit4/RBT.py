from __future__ import print_function

BLACK = 1
RED = 2


class Node:
    def __init__(self):
        self.data = None
        self.nodeColor = None
        self.parent = None
        self.lchild = None
        self.rchild = None


def inorder(root):
    if root is not None:
        inorder(root.lchild)
        print("%d %d" % (root.data, root.nodeColor))
        inorder(root.rchild)


def getGrandParent(N):
    if ((N is not None) and (N.parent is not None)):
        return N.parent.parent
    else:
        return None


def getUncle(N):
    G = getGrandParent(N)

    # No grandparent means No uncle
    if G is None:
        return None

    if N.parent == G.lchild:
        return G.rchild
    else:
        return G.lchild


def GetNode(element):
    temp = Node()
    temp.data = element
    temp.nodeColor = RED
    temp.lchild = None
    temp.rchild = None
    temp.parent = None
    return temp


# BST insertion is performed
def Insert_BST(root, element):
    currentNode = root
    parentNode = Node()

    if root is None:
        currentNode = root = GetNode(element)
    else:
        while currentNode is not None:
            parentNode = currentNode
            if element < currentNode.data:
                currentNode = currentNode.lchild
            else:
                currentNode = currentNode.rchild
        currentNode = GetNode(element)
        if currentNode.data < parentNode.data:
            parentNode.lchild = currentNode
        else:
            parentNode.rchild = currentNode
        currentNode.parent = parentNode
    root = checkRedBlackProperties(root, currentNode)
    return root


def checkRedBlackProperties(root, n):
    if n == root:
        # case 1 root node should always be black
        n.nodeColor = BLACK
        return root

    if n.parent.nodeColor == BLACK:
        # case 2: no violation
        return root
    else:
        # case 3: newly inserted node's parent is red .property 4 violated
        while n != root and n.parent.nodeColor == RED:
            uncle = getUncle(n)
            grandParent = getGrandParent(n)
            if grandParent is not None:
                # case 3.1
                if uncle is not None and uncle.nodeColor == RED:
                    # uncle is RED
                    n.parent.nodeColor = BLACK
                    uncle.nodeColor = BLACK
                    grandParent.nodeColor = RED
                    n = grandParent
                else:
                    # uncle is BLACK
                    if n.parent == grandParent.lchild:
                        if n == n.parent.rchild:
                            # case 3.2:
                            # parent is the left child of granfparent
                            # current node is right child of parent
                            n = n.parent
                            root = rotateLeft(root, n)
                        # Case 3.3 :
                        # Parent(P) is the left child of its parent(G).
                        # The current node(N) is the left child of the
                        # parent(P) and the uncle(U) is black.

                        n.parent.nodeColor = BLACK
                        getGrandParent(n).nodeColor = RED
                        root = rotateRight(root, getGrandParent(n))

                    else:

                        # current node's parent is right child of grand parent
                        if n == n.parent.lchild:
                            # Case 3.4:
                            # Parent(P) is the right child of its parent(G).
                            # The current node(N) is the left child of the
                            # parent(P) and the uncle(U) is black.

                            n = n.parent
                            root = rotateRight(root, n)

                        # case 3.5
                        # Parent(P) is the right child of its parent(G).
                        # The current node(N) is the right child of the
                        # parent(P) and the uncle(U) is black.

                        n.parent.nodeColor = BLACK
                        getGrandParent(n).nodeColor = RED
                        root = rotateLeft(root, getGrandParent(n))
    root.nodeColor = BLACK
    return root


def rotateLeft(root, nodeToBeRotated):
    child = nodeToBeRotated.rchild
    nodeToBeRotated.rchild = child.lchild
    if child.lchild is not None:
        child.lchild.parent = nodeToBeRotated

        # if (child != None)
        child.parent = nodeToBeRotated.parent

    if (nodeToBeRotated.parent):
        if nodeToBeRotated == nodeToBeRotated.parent.lchild:
            nodeToBeRotated.parent.lchild = child
        else:
            nodeToBeRotated.parent.rchild = child
    else:
        root = child
    child.lchild = nodeToBeRotated
    if nodeToBeRotated is not None:
        nodeToBeRotated.parent = child
    return root


def rotateRight(root, nodeToBeRotated):
    child = nodeToBeRotated.lchild
    nodeToBeRotated.lchild = child.rchild
    if child.rchild is not None:
        child.rchild.parent = nodeToBeRotated
        child.parent = nodeToBeRotated.parent
    if nodeToBeRotated.parent:
        if nodeToBeRotated == nodeToBeRotated.parent.rchild:
            nodeToBeRotated.parent.rchild = child
        else:
            nodeToBeRotated.parent.lchild = child
    else:
        root = child
    child.rchild = nodeToBeRotated
    if nodeToBeRotated is not None:
        nodeToBeRotated.parent = child
    return root


def Delete_BST(root, key):
    # nodes and their roles played
    nodeToBeDeleted = root  # N in algorithm
    successor = None  # I and D in algorithm
    child = None  # C in algorithm

    # find the node to be deleted
    while (nodeToBeDeleted is not None):
        if (nodeToBeDeleted.data == key):
            break
        else:
            if (nodeToBeDeleted.data > key):
                nodeToBeDeleted = nodeToBeDeleted.lchild
            else:
                nodeToBeDeleted = nodeToBeDeleted.rchild

    if nodeToBeDeleted is None:
        print("Node not found")
        return root

    # finding the replacement node for the node to be deleted
    if nodeToBeDeleted.lchild is None or nodeToBeDeleted.rchild is None:
        # successor has a None(BLACK) node as a child
        successor = nodeToBeDeleted
    else:
        # find the inorder successor with a None(BLACK) node as a child
        successor = nodeToBeDeleted.rchild
        while successor.lchild is not None:
            successor = successor.lchild
    # child is successor's only child
    if successor.lchild is not None:
        child = successor.lchild
    elif successor.rchild is not None:
        child = successor.rchild

    if successor != nodeToBeDeleted:
        # Copy the value of the inorder successor(I) in the node(N) to be deleted
        # Mark I as D and Is child as C
        nodeToBeDeleted.data = successor.data

    # Proceed to the cases for deletion
    root = Deletion_cases(root, successor, child)

    # return new root
    return root


def Deletion_cases(root, D, C):
    # Case 1 : D is red
    if (D.nodeColor == RED and (C is None or C.nodeColor == BLACK)):
        root = replaceNode(root, D, C)
        return root

    # Case 2 : D is black and C is red
    if (D.nodeColor == BLACK and (C is not None and C.nodeColor == RED)):
        # D is replaced with C
        # Repaint C black
        root = replaceNode(root, D, C)
        C.nodeColor = BLACK
        return root

    # Case 3 : D and C are black
    if D.nodeColor == BLACK and (C is None or C.nodeColor == BLACK):

        parent = D.parent
        root = replaceNode(root, D, C)
        if (C is not None):
            parent = C.parent

        if (C == root):
            # Sub Case 3.1 : C is the new root
            return root

        while (C != root and (C is None or C.nodeColor == BLACK)):

            # Sub Case 3.2 :  C is the left child of P
            #                Sibling(S) of C is red
            if (parent.lchild == C and (
                    parent.rchild is not None and parent.rchild.nodeColor == RED)):
                parent.rchild.nodeColor = BLACK
                parent.nodeColor = RED
                root = rotateLeft(root, parent)

            # Sub Case 3.3 :  i) C is the left child of P
            #                 ii) P, S and S's children are black
            if (parent.lchild == C and parent.nodeColor == BLACK):

                sibling = parent.rchild
                if (sibling is not None and sibling.nodeColor == BLACK):

                    if ((sibling.lchild is None or sibling.lchild.nodeColor == BLACK) and (
                            sibling.rchild is None or sibling.rchild.nodeColor == BLACK)):
                        # Repaint S red
                        sibling.nodeColor = RED
                        C = parent
                        parent = C.parent

            # Sub Case 3.4 :  i) C is the left child of P
            #                 ii) S and S's children are black, but P is red
            if (parent.lchild == C and parent.nodeColor == RED):

                sibling = parent.rchild
                if (sibling is not None and sibling.nodeColor == BLACK):

                    if ((sibling.lchild is None or sibling.lchild.nodeColor == BLACK) and (
                            sibling.rchild is None or sibling.rchild.nodeColor == BLACK)):
                        # Swap the colours of Sibling and Parent
                        temp = sibling.nodeColor
                        sibling.nodeColor = parent.nodeColor
                        parent.nodeColor = temp

            # Sub Case 3.5 : i) C is the left child of P
            # ii) S is black, S's left child is red, S's right child is black
            if (parent.lchild == C):

                sibling = parent.rchild
                if (sibling is not None and sibling.nodeColor == BLACK):

                    if ((sibling.lchild is not None and sibling.lchild.nodeColor == RED) and (
                            sibling.rchild is None or sibling.rchild.nodeColor == BLACK)):
                        root = rotateRight(root, sibling)
                        temp = sibling.nodeColor
                        sibling.nodeColor = sibling.parent.nodeColor
                        sibling.parent.nodeColor = temp

            # Sub Case 3.6 : i) C is the left child of P
            #              ii) S is black, S's right child is red
            if (parent.lchild == C):

                sibling = parent.rchild
                if (sibling is not None and sibling.nodeColor == BLACK):

                    if (sibling.rchild is not None and sibling.rchild.nodeColor == RED):
                        root = rotateLeft(root, parent)
                        temp = sibling.nodeColor
                        sibling.nodeColor = parent.nodeColor
                        parent.nodeColor = temp
                        sibling.rchild.nodeColor = BLACK

            # Sub Case 3.7 :  C is the right child of P
            #                Sibling(S) of C is red
            if (parent.rchild == C and (
                    parent.lchild is not None and parent.lchild.nodeColor == RED)):
                parent.rchild.nodeColor = BLACK
                parent.nodeColor = RED
                root = rotateRight(root, parent)

            # Sub Case 3.8 :  i) C is the right child of P
            #               ii) P, S and S's children are black
            if (parent.rchild == C and parent.nodeColor == BLACK):

                sibling = parent.lchild
                if (sibling is not None and sibling.nodeColor == BLACK):

                    if ((sibling.lchild is None or sibling.lchild.nodeColor == BLACK) and (
                            sibling.rchild is None or sibling.rchild.nodeColor == BLACK)):
                        # Repaint S red
                        sibling.nodeColor = RED
                        C = parent
                        parent = C.parent

            # Sub Case 3.9 :  i) C is the right child of P
            #               ii) S and S's children are black, but P is red
            if (parent.rchild == C and parent.nodeColor == RED):

                sibling = parent.lchild
                if (sibling is not None and sibling.nodeColor == BLACK):

                    if ((sibling.lchild is None or sibling.lchild.nodeColor == BLACK) and (
                            sibling.rchild is None or sibling.rchild.nodeColor == BLACK)):
                        # Swap the colours of Sibling and Parent
                        int
                        temp = sibling.nodeColor
                        sibling.nodeColor = parent.nodeColor
                        parent.nodeColor = temp

            # Sub Case 3.10 : i) C is the right child of P
            # ii) S is black, S's right child is red, S's left child is black
            if (parent.rchild == C):

                sibling = parent.lchild
                if (sibling is not None and sibling.nodeColor == BLACK):

                    if ((sibling.rchild is not None and sibling.rchild.nodeColor == RED) and (
                            sibling.lchild is None or sibling.lchild.nodeColor == BLACK)):
                        root = rotateLeft(root, sibling)
                        temp = sibling.nodeColor
                        sibling.nodeColor = sibling.parent.nodeColor
                        sibling.parent.nodeColor = temp

            # Sub Case 3.11 : i) C is the right child of P
            #              ii) S is black, S's left child is red
            if (parent.rchild == C):

                sibling = parent.lchild
                if (sibling is not None and sibling.nodeColor == BLACK):

                    if (sibling.lchild is not None and sibling.lchild.nodeColor == RED):
                        root = rotateRight(root, parent)
                        temp = sibling.nodeColor
                        sibling.nodeColor = parent.nodeColor
                        parent.nodeColor = temp
                        sibling.lchild.nodeColor = BLACK

        # while ends

        C.nodeColor = BLACK
        return root


def replaceNode(root, D, C):
    # remove D and replace with C
    if D.parent is None:
        # D is the root node
        root = C
        C.parent = None
        return root

    if (C is not None):
        C.parent = D.parent
    if (D == D.parent.lchild):
        D.parent.lchild = C
    else:
        D.parent.rchild = C
    return root


exitFlag = True
root = None
while exitFlag:
    choice = int(
        input("\n1. Insert\n2. Delete\n3. Inorder\n4. Exit\nChoice : "))
    if choice == 1:
        arr = raw_input(
            "\nEnter the elements to enter with space : ").split(" ")
        for element in arr:
            root = Insert_BST(root, int(element))
        inorder(root)

    elif choice == 2:
        element = int(input("Enter element to delete : "))
        root = Delete_BST(root, element)
        inorder(root)
    elif choice == 3:
        inorder(root)
    elif choice == 4:
        exitFlag = False
    else:
        print("Invalid option")
