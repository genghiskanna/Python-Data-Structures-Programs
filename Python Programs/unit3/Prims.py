from __future__ import print_function

ne = 1
mincost = 0
visited = [0] * 10
cost = [[0] * 10] * 10
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
visited[1] = 1
print("\n")
while ne < n:
    min = 999
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            if cost[i][j] < min:
                if visited[i] != 0:
                    min = cost[i][j]
                    a = i
                    u = i
                    b = j
                    v = j
                if (visited[u] == 0) or (visited[v] == 0):
                    print("Edge %d:(%d %d) cost:%d" % (ne, a, b, min))
                    ne += 1
                    mincost += min
                    visited[b] = 1
                cost[a][b] = 999
                cost[b][a] = 999
print("Minimum cost=%d" % mincost)
