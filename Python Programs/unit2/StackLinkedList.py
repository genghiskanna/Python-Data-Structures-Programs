from __future__ import print_function

top = None


class Node(object):

    def __init__(self, data=None, prev_node=None):
        self.data = data
        self.prev_node = prev_node


def pushS():
    global top
    print("Enter the value:")
    value = int(input())
    newNode = Node(data=value)
    if top is None:
        top = newNode
    else:
        newNode.prev_node = top
        top = newNode


def popS():
    global top
    temp = top.data
    top = top.prev_node
    return temp


def display():
    global top
    if top is None:
        print("Stack is empty:")
    else:
        temp = top
        while temp is not None:
            print(str(temp.data) + " ", end="")
            temp = temp.prev_node
        print("")


while True:
    print("Stack implementation in Linked List")
    print("1.Push\n2.Pop\n3.Display\n4.Exit")
    c = int(input("Enter your choice : "))
    if c == 1:
        pushS()
    elif c == 2:
        print("The element popped is %d" % popS())
    elif c == 3:
        display()
    elif c == 4:
        exit(0)

    else:
        print("Wrong Choice")
