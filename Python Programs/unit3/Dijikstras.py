from __future__ import print_function

INFINITY = 999


def dij(n, v, cost, dist):
    flag = [0] * 10
    for i in range(1, n + 1):
        flag[i] = 0
        dist[i] = cost[v][i]
    count = 2
    while (count <= n):
        min = 99
        for w in range(1, n + 1):
            if (dist[w] < min and not (flag[w])):
                min = dist[w]
                u = w
            flag[u] = 1
        count += 1
    for w in range(1, n + 1):
        if ((dist[u] + cost[u][w] < dist[w]) and not (flag[w])):
            dist[w] = dist[u] + cost[u][w]


cost = [[0] * 10] * 10
dist = [0] * 10
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
v = int(input("\n Enter the source vertex:"))
dij(n, v, cost, dist)
print("\n Shortest path:\n")
for i in range(1, n + 1):
    if i != v:
        print("%d->%d,cost=%d\n" % (v, i, dist[i]))
