from __future__ import print_function


def Array_Deletion(array, size, element):
    for i in range(0, size):
        if array[i] == element:
            for j in (i + 1, size - 1):
                print(array[j - 1])
                array[j - 1] = array[j]
    print("array after deletion")
    for i in range(0, n - 1):
        print("%d" % array[i])


arr = []
print("************DELETION OF AN ELEMENT IN ARRAY************")
print("Enter the number of elements in an array")
n = int(input())
print("Enter the elements")
for i in range(0, n):
    arr.append(int(input()))
print("Elements in the array")
for i in arr:
    print("%d" % i)
print("Enter the element to be deleted")
e = int(input())

# deletion of element
Array_Deletion(arr, n, e)
