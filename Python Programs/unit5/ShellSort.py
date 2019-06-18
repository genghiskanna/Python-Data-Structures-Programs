from __future__ import print_function


def ShellSort(arr):
    n = len(arr)
    increment = n / 2
    while increment > 0:
        for i in range(increment, n):
            temp = arr[i]
            j = i
            while (j >= (increment)) and (arr[j - increment] > temp):
                arr[j] = arr[j - increment]
                j = j - increment
            arr[j] = temp
        print("Intermediate List : ")
        for i in range(0, n):
            print(" %d " % arr[i])
        increment = int(increment / 2)



# replace raw_input with input if Python3
arr = [int(x) for x in raw_input(
    "Enter the elements of the array with space : \n").split(" ")]
ShellSort(arr)
print("Sorted List : ")
print(arr)
