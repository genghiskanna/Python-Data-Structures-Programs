from __future__ import print_function

start = None
rear = None


class Node(object):

    def __init__(self, data=None, next_node=None):
        self.data = data
        self.next_node = next_node


def create():
    global start, rear
    print("Enter the value:")
    value = int(input())
    newNode = Node(data=value)
    if start is None:
        start = newNode
        rear = newNode
    else:
        rear.next_node = newNode
        rear = rear.next_node


def display():
    global start
    if start is None:
        print("Queue is empty:")
    else:
        temp = start
        while temp is not None:
            print(temp.data)
            temp = temp.next_node


def delete_node():
    global start
    num = start.data
    start = start.next_node
    return num


while True:
    print("1.INSERT\n2.DELETE\n3.EXIT")
    c = int(input("Enter your choice : "))
    if c == 1:
        create()
    elif c == 2:
        if start is None:
            print("Empty Queue linked list")
        else:
            print("Before deleting:")
            display()
            num = delete_node()
            print("after deleting:")
            display()
            print("Deleted %d" % num)

    elif c == 3:
        exit(0)
    else:
        print("Invalid choice")
