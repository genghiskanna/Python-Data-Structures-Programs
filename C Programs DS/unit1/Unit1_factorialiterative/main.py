from __future__ import print_function

def factorial(int n):
    factorial=1;
    for i in range(2,n):
        factorial=factorial*i;
    return factorial
    
    
print("Enter the number to find factorial")
n = int(raw_input())
print("FACTORIAL : %d"%factorial(n))

