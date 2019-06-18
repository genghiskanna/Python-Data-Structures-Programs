from __future__ import print_function

start = None


class Node(object):

    def __init__(self, data=None, next_node=None, prev_node=None):
        self.data = data
        self.next_node = next_node
        self.prev_node = prev_node


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
        newNode.prev_node = temp


def display():
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
    print("1.INSERT\n2.EXIT")
    c = int(input("Enter your choice : "))
    if c == 1:
        create()
        display()
    elif c == 2:
        exit(0)
    else:
        print("Invalid choice")
