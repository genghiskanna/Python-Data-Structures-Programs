from __future__ import print_function

# Merges two subarrays of arr[]


def merge(arr, low, mid, high):
    n1 = mid - low + 1
    n2 = high - mid
    # temp arrays
    leftSubArray = [0] * (n1)
    rightSubArray = [0] * (n2)

    for i in range(0, n1):
        leftSubArray[i] = arr[low + i]
    for j in range(0, n2):
        rightSubArray[j] = arr[mid + 1 + j]
    i = 0
    j = 0
    k = low
    while i < n1 and j < n2:
        if leftSubArray[i] <= rightSubArray[j]:
            arr[k] = leftSubArray[i]
            i += 1
        else:
            arr[k] = rightSubArray[j]
            j += 1
        k += 1
    # copy the remaining elements leftSubArray if any
    while i < n1:
        arr[k] = leftSubArray[i]
        i += 1
        k += 1
    # Copy the remaining elements of rightSubArray if any
    while j < n2:
        arr[k] = rightSubArray[j]
        j += 1
        k += 1


def mergeSort(arr, low, high):
    if low < high:

        mid = (low + high) / 2

        # Sort first and second halves
        mergeSort(arr, low, mid)
        mergeSort(arr, mid + 1, high)
        merge(arr, low, mid, high)



# replace raw_input with input if Python3
arr = [int(x) for x in raw_input(
    "Enter the elements of the array with space : \n").split(" ")]
n = len(arr)

mergeSort(arr, 0, n - 1)
print ("\n\nSorted array is")
print(arr)
