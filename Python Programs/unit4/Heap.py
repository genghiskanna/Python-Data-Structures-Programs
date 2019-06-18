from __future__ import print_function


def heapify(arr, n, i):
    largest = i  # Initialize largest as root
    l = 2 * i + 1  # left = 2*i + 1
    r = 2 * i + 2  # right = 2*i + 2

    # if left child exists and greater
    if l < n and arr[i] < arr[l]:
        largest = l

    # if right child exists and greater
    if r < n and arr[largest] < arr[r]:
        largest = r

    if largest != i:
        arr[i], arr[largest] = arr[largest], arr[i]  # swap
        heapify(arr, n, largest)


def heapSort(arr):
    n = len(arr)

    # Build a maxheap.
    for i in range(n, -1, -1):
        heapify(arr, n, i)

    # One by one extract elements
    for i in range(n - 1, 0, -1):
        arr[i], arr[0] = arr[0], arr[i]  # swap
        heapify(arr, i, 0)


# Driver code to test above
arr = [int(x) for x in raw_input(
    "Enter the numbers to sort separted by space : \n").split(" ")]
heapSort(arr)
n = len(arr)
print ("Sorted array is")
print(arr)
