from __future__ import print_function

ne = 1
mincost = 0
cost = [[0] * 9] * 9
parent = [0] * 9


def find(i):
    while parent[i]:
        i = parent[i]
    return i


def uni(i, j):
    if i != j:
        parent[j] = i
        return 1
    else:
        return 0


n = int(input("Enter the no. of Vertices :"))
print("Enter the Adjacency Matrix:")
for i in range(1, n + 1):
    # replace raw_input with input if Python3
    arr = [
        int(x) for x in raw_input(
            "Enter Adjacency of %d node with space: \n" %
            i).split(" ")]
    arr.insert(0, 0)
    cost.insert(i, arr)

print("Adjacency Matrix")
for i in range(1, n + 1):
    print("")
    for j in range(1, n + 1):
        print(" %d " % cost[i][j], end="")
print("")


print("The edges of Minimum Cost Spanning Tree are")
while ne < n:
    min = 999
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            if cost[i][j] < min:
                min = cost[i][j]
                a = i
                u = i
                b = j
                v = j
    u = find(u)
    v = find(v)
    if (uni(u, v)):
        print("%d edge (%d,%d) =%d" % (ne, a, b, min))
        ne += 1
        mincost += min
    cost[a][b] = 999
    cost[b][a] = 999
print("\tMinimum cost = %d\n" % mincost)
