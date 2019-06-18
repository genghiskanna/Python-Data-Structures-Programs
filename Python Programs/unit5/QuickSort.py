from __future__ import print_function


# This function takes last element as pivot
def partition(arr, low, high):
    i = (low - 1)
    pivot = arr[high]

    for j in range(low, high):

        if arr[j] <= pivot:
            i = i + 1
            arr[i], arr[j] = arr[j], arr[i]

    arr[i + 1], arr[high] = arr[high], arr[i + 1]
    return (i + 1)


def quickSort(arr, low, high):
    if low < high:
        pi = partition(arr, low, high)

        # Separately sort elements before partition and after partition
        quickSort(arr, low, pi - 1)
        quickSort(arr, pi + 1, high)


# replace raw_input with input if Python3
arr = [int(x) for x in raw_input(
    "Enter the elements of the array with space : \n").split(" ")]
n = len(arr)
quickSort(arr, 0, n - 1)
print ("Sorted array is:")
print(arr)
