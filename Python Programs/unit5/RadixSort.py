from __future__ import print_function


def countingSort(arr, exp1):
    n = len(arr)
    output = [0] * (n)
    count = [0] * (10)

    # occurrences stored in count
    for i in range(0, n):
        index = (arr[i] / exp1)
        count[(index) % 10] += 1

    for i in range(1, 10):
        count[i] += count[i - 1]

    # Build the output array
    i = n - 1
    while i >= 0:
        index = (arr[i] / exp1)
        output[count[(index) % 10] - 1] = arr[i]
        count[(index) % 10] -= 1
        i -= 1

    i = 0
    for i in range(0, len(arr)):
        arr[i] = output[i]


def radixSort(arr):
    # Find the maximum number to know number of digits
    max1 = max(arr)

    # Do counting sort for every digit.
    exp = 1
    while max1 / exp > 0:
        countingSort(arr, exp)
        exp *= 10



# replace raw_input with input if Python3
arr = [int(x) for x in raw_input(
    "Enter the elements of the array with space : \n").split(" ")]
radixSort(arr)
print(arr)
