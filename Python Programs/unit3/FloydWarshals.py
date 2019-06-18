
from __future__ import print_function


def display(a, n):
    for i in range(0, n):
        for j in range(0, n):
            print("%d " % a[i][j])
        print("")


def Floyd(COST, n):
    DISTANCE = [[0] * n] * n
    for i in range(0, n):
        for j in range(0, n):
            DISTANCE[i][j] = COST[i][j]
    for k in range(0, n):
        for i in range(0, n):
            for j in range(0, n):
                DISTANCE[i][j] = minimum(
                    DISTANCE[i][j], DISTANCE[i][k] + DISTANCE[k][j])
        print("k = %d" % k)
        display(DISTANCE, n)


def minimum(a1, b):
    if a1 < b:
        return a1
    else:
        return b


n = int(input("Enter the number of vertices:"))
COST = [[0] * n] * n
print("Enter the cost matrix(Enter large numbers for non-existent edges):\n")
for i in range(0, n):
    for j in range(0, n):
        COST[i][j] = int(input())
Floyd(COST, n)
