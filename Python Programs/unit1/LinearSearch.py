from __future__ import print_function


def Linear_Search(array, element):
    n = len(array)
    for i in range(0, n):
        if array[i] == element:
            print("The element is found at the %d position in the array" % i)
            return
    print("The element searched was not found")


arr = []
print("Enter the number of elements in an array")
n = int(raw_input())
print("Enter the elements")
for i in range(0, n):
    arr.append(int(raw_input()))
print("Elements in the array")
for i in arr:
    print("%d" % i)
print("Enter the element to search")
element = int(input())
Linear_Search(arr, element)
