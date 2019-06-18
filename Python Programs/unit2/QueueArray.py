from __future__ import print_function


MAX = 5
QUEUE = [0] * MAX
front = -1
rear = -1


def insert():
    global QUEUE, MAX, rear, front

    if rear == MAX - 1:
        print("Queue Overflow \n")
    else:
        if front == - 1:
            front = 0
        add_item = int(input("Insert the element in queue : "))
        rear += 1
        QUEUE[rear] = add_item


def delete():
    global QUEUE, MAX, rear, front

    if front == - 1 or front > rear:
        print("Queue Underflow")
    else:
        print("Element deleted from queue is : %d\n", QUEUE[front])
        front += 1


def display():
    global QUEUE, MAX, rear, front

    if front == - 1:
        print("Queue is empty")
    else:
        print("Queue is : ")
        for i in range(front, rear):
            print("%d " % QUEUE[i], end="")
        print("")


while True:
    print("1.Insert element to queue")
    print("2.Delete element from queue")
    print("3.Display all elements of queue")
    print("4.Quit")
    choice = int(input("Enter your choice : "))
    if choice == 1:
        insert()
    elif choice == 2:
        delete()
    elif choice == 3:
        display()
    elif choice == 4:
        exit(0)
    else:
        print("Wrong choice")
