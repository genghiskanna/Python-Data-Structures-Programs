from __future__ import print_function


def Binary_Search(array, low, high, elementToSearch):
    if low > high:
        print("Element not found")
        return -1
    mid = (low + high) / 2
    if array[mid] == elementToSearch:
        print("Element is found in the array")
        return mid
    if array[mid] > elementToSearch:
        Binary_Search(array, low, mid - 1, elementToSearch)
    else:
        Binary_Search(array, mid + 1, high, elementToSearch)


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
e = int(input())
Binary_Search(array=arr, low=0, high=n - 1, elementToSearch=e)
