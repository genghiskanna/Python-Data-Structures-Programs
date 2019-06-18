from __future__ import print_function


def factorial(n):
    if n == 1:
        return 1
    else:
        return n * factorial(n - 1)


print("Enter the number to find factorial")
n = int(input())
print("FACTORIAL: %d" % factorial(n))
