from __future__ import print_function


# replace raw_input with input if Python3
arr = [int(x) for x in raw_input(
    "Enter the elements of the array with space : \n").split(" ")]

for i in range(len(arr)):

    # Find the minimum element
    min_index = i
    for j in range(i + 1, len(arr)):
        if arr[min_index] > arr[j]:
            min_index = j

    arr[i], arr[min_index] = arr[min_index], arr[i]

print ("Sorted array")
print(arr)
