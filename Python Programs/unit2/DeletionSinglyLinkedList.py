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


def display():
    global start
    if start is None:
        print("List is empty:")
    else:
        temp = start
        while temp is not None:
            print(temp.data)
            temp = temp.next_node


def delete_node():
    global start
    print("Enter the number to be deleted:")
    number = int(input())
    temp = start
    if start.data == number:
        start = start.next_node
    else:
        while temp is not None:
            if temp.data == number:
                previous.next_node = temp.next_node
                break
            previous = temp
            temp = temp.next_node


while True:
    print("1.INSERT\n2.DELETE\n3.EXIT")
    c = int(input("Enter your choice : "))
    if c == 1:
        create()
    elif c == 2:
        if start is None:
            print("Empty linked list")
        else:
            print("Before deleting:")
            display()
            delete_node()
            print("after deleting:")
            display()

    elif c == 3:
        exit(0)
    else:
        print("Invalid choice")
