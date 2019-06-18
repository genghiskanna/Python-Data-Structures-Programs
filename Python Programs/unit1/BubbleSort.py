from __future__ import print_function


def Bubble_Sort():
    #    global array,n
    for i in range(0, n):
        for j in range(0, n):
            if(array[i] < array[j]):
                temp = array[i]
                array[i] = array[j]
                array[j] = temp


array = []
print("Enter the number of elements in an array")
n = int(raw_input())
print("Enter the elements")
for i in range(0, n):
    array.append(int(raw_input()))
print("Elements in the array")
for i in array:
    print("%d" % i)
Bubble_Sort()
print("Elements in sorted order")
for i in array:
    print("%d" % i)
