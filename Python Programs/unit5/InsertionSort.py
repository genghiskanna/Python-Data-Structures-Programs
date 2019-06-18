from __future__ import print_function


def insertionSort(arr):
    for i in range(1, len(arr)):

        key = arr[i]

        # Move elements of arr[0..i-1], that are
        # greater than key, to one position ahead of their current position
        j = i - 1
        while j >= 0 and key < arr[j]:
            arr[j + 1] = arr[j]
            j -= 1
        arr[j + 1] = key


# replace raw_input with input if Python3
arr = [int(x) for x in raw_input(
    "Enter the elements of the array with space : \n").split(" ")]
insertionSort(arr)
print ("Sorted array is:")
print(arr)
