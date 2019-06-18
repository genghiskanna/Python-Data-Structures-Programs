from __future__ import print_function

start = None


class Node(object):

    def __init__(self, data=None, next_node=None):
        self.data = data
        self.next_node = next_node


def create():
    global start
    print("Enter the value:")
    value = int(input())
    newNode = Node(data=value)
    if start is None:
        start = newNode
    else:
        temp = start
        while temp.next_node is not None:
            temp = temp.next_node
        temp.next_node = newNode


def TraversalLinkedList():
    global start
    if start is None:
        print("List is empty:")
    else:
        temp = start
        while temp is not None:
            print(str(temp.data) + " ", end="")
            temp = temp.next_node
        print("")


while True:
    create()
    c = int(input("Enter 1 to continue populating the list , 2 to traverse"))
    if c == 2:
        break

TraversalLinkedList()
