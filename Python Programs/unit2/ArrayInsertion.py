from __future__ import print_function


def Array_Insertion(array, n, element, pos):
    array.append(0)  # Increasing the size of the array
    print("No. of element : %d,pos : %d" % (n, pos))
    for i in reversed(range(pos, n)):
        array[i + 1] = array[i]  # SWAPPING
    print("element : %d,pos : %d" % (element, pos))
    if pos > n:
        array[pos - 1] = element
    else:
        array[pos] = element  # INSERTION OF ELEMENTS

    print("array[pos] = %d, n=%d" % (array[pos], n))
    n += 1
    print("****after insertion****")
    for i in range(0, n):
        print("%d\t" % array[i])
    print("no of elements=%d" % n)


arr = []
print("Enter the number of elements in an array")
n = int(input())
print("Enter the elements")
for i in range(0, n):
    arr.append(int(input()))
print("Elements in the array")
for i in arr:
    print("%d" % i)

print("no of elements=%d\n Enter the element to be inserted" % n)
e = int(input())
print("enter the position of the element\n")
pos = int(input())
if(pos > 100):
    print("Insertion not possible")
else:
    Array_Insertion(arr, n, e, pos)
