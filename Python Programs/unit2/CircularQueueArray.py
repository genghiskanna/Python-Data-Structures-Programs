from __future__ import print_function

SIZE = 5
front = -1
rear = -1
queue = [0] * SIZE


def insertQ():
    global front, rear
    if (front == 0 and rear == SIZE - 1) or (front == rear + 1):
        print("Queue is full.")
    else:
        print("Enter ITEM: ")
        item = int(input())
        if rear == -1:
            rear = 0
            front = 0
        elif rear == SIZE - 1:
            rear = 0
        else:
            rear += 1
        print(rear)
        print(front)
        queue[rear] = item
        print("Item inserted: %d\n" % item)


def deleteQ():
    global front, rear
    if front == -1:
        print("Queue is empty.\n")
    else:
        item = queue[front]
        if front == rear:
            front = -1
            rear = -1
        elif front == SIZE - 1:
            front = 0
        else:
            front += 1
    print("ITEM deleted: %d" % item)


def displayQ():
    if (front == -1) or (front == rear + 1):
        print("Queue is empty.\n")
    else:
        for i in range(front, rear + 1):
            print("\t%d" % queue[i])


while True:
    print("1.\tInsert\n2.\tDelete\n3.\tDisplay\n4.\tExit")
    print("Enter your choice: ")
    ch = int(input())
    if ch == 1:
        insertQ()
    elif ch == 2:
        deleteQ()
    elif ch == 3:
        displayQ()
    elif ch == 4:
        exit(0)
    else:
        print("Invalid choice...")
