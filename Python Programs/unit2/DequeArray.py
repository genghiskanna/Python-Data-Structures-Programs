from __future__ import print_function

left = -1
right = -1
n = 11
arr = [0] * n


def enqueue_left(x):
    global left, right, n, arr
    if (left == 0) and (right == n) or (left - 1 == right):
        print("overflow......")
        return
    elif left == -1:
        right = 0
        left = n - 1
    elif left == 0:
        left = n - 1
    else:
        left = left - 1
    print(left, right)
    arr[left] = x
    print(arr)


def enqueue_right(x):
    global left, right, n, arr
    if (left == 0) and (right == n) or (left - 1 == right):
        print("Overflow......")
        return
    elif left == -1:
        left = right = 0
    elif right == n:
        right = 0
    else:
        right = right + 1
    print(left, right)
    arr[right] = x


def dequeue_left():
    global left, right, n, arr
    if (left == -1):
        print("underflow")
        elt = -1
    elif left == right:
        elt = arr[left]
        left = right = -1
    elif left == n:
        elt = arr[left]
        left = 1
    else:
        elt = arr[left]
        left = left + 1
    return elt


def dequeue_right():
    global left, right, n, arr
    if left == -1:
        print("underflow")
        elt = -1

    elif left == right:
        elt = arr[right]
        left = right = -1

    elif right == 0:
        elt = arr[right]
        right = n - 1
    else:
        elt = arr[right]
        right = right - 1

    return elt


def display():
    global left, right, n, arr
    print("left: %d right:%d" % (left, right))
    if (left == right and left == -1):
        print("Queue is empty")
        return
    print("the elements of the queue are")
    if left <= right:
        for i in range(left, right):
            print(" %d %d" % (i, arr[i]))
    else:
        for i in range(0, right):
            print(" %d %d\n" % (i, arr[i]))
        for i in reversed(range(left, n)):
            print(" %d %d\n" % (i, arr[i]))


print("\tDEQUE")
while True:
    print("1.enqueue left")
    print("2.enqueue right")
    print("3.dequeue left")
    print("4.dequeue right")
    print("5.display the queue")
    ch = int(input("enter your choice...."))
    if ch == 1:
        element = int(input("enter an element to be inserted at left"))
        enqueue_left(element)
    elif ch == 2:
        element = int(input("enter an element to be inserted at right"))
        enqueue_right(element)
    elif ch == 3:
        z = dequeue_left()
        if z == -1:
            print("queue is empty")
        else:
            print("deleted element is %d" % z)
    elif ch == 4:
        z = dequeue_right()
        if z == -1:
            print("\n\nqueue is empty")
        else:
            print("\n\ndeleted element is %d" % z)
    elif ch == 5:
        display()
