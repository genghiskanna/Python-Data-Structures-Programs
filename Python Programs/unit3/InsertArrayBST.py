from __future__ import print_function

# INSERTION AND DELETION ON ARRAY IMPLEMENTATION OF BINARY SEARCH TREE
# int NaN=-1


def restore_BST():
    global TREE, n
    temp = TREE
    TREE = [0] * n
    for i in temp:
        insertBST(i)


def insertBST(num):
    global TREE
    i = 0
    try:
        while num:
            if TREE[i] == 0:
                TREE[i] = num
                num = 0
            elif TREE[i] > num:
                i = 1 if i == 0 else i * 2
            else:
                i = 2 if i == 0 else (i * 2) + 1
    except IndexError:
        print("Tree Full")


def deleteBST():
    global TREE
    num = int(input("Enter the number to Delete : "))
    i = 0
    while num:
        # find the inorder successor
        temp = sorted(TREE)
        try:
            successor = temp[temp.index(num) + 1]
        except ValueError:
            print("%d does not exist!" % num)
            return 0
        # replace the element with the successor
        if successor == 0:  # leaf node
            TREE.remove(num)
            num = 0
        else:
            TREE.remove(successor)
            TREE[TREE.index(num)] = successor
            num = 0
    restore_BST()


n = int(input("Enter the size of the array considered as tree : "))
TREE = [0] * (n)

while True:
    c = int(input("1.Insert\n2.Delete\n3.Display\n4.Exit\nChoice : "))
    if c == 1:
        num = int(input("Enter the number to insert : "))
        insertBST(num)
    elif c == 2:
        deleteBST()
    elif c == 3:
        print(TREE)

    elif c == 4:
        exit(0)
    else:
        print("Wrong Choice")
