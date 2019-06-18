from __future__ import print_function


queue = []
InDegree = [0] * 10


def TopologicalSort(AdjMat, n):
    status = [0] * 10  # 0-unvisited,1-in queue,2-visited
    for i in range(0, n):
        InDegree[i] = 0
        status[i] = 0
    for i in range(0, n):
        for j in range(0, n):
            if AdjMat[i][j] != 0:
                InDegree[j] += 1
    print("Indegree : ")
    for i in range(0, n):
        print("%d : %d" % (i, InDegree[i]))
    for i in range(0, n):
        if InDegree[i] == 0:
            queue.append(i)
    while len(queue) != 0:
        u = queue.pop(0)
        status[u] = 2
        print("\nTopological Sort : ")
        print("%d\n" % (u + 1))
        for w in range(0, n):
            if AdjMat[u][w] > 0 and status[w] != 2:
                InDegree[w] -= 1
            if InDegree[w] == 0 and status[w] == 0:
                print("In queue : %d", (w + 1))
                status[w] = 1
                queue.append(w)
                print("\n\nIndegree : ")
                for i in range(0, n):
                    print("%d : %d" % (i, InDegree[i]))


AdjMat = []
n = int(input("Enter the no. of Vertices :"))
print("Enter the Adjacency Matrix:")
for i in range(0, n):
    # replace raw_input with input if Python3
    arr = [
        int(x) for x in raw_input(
            "Enter Adjacency of %d node with space: \n" %
            i).split(" ")]
    AdjMat.append(arr)

print("Adjacency Matrix ")
for i in range(0, n):
    print("")
    for j in range(0, n):
        print(AdjMat[i][j], end=" ")
print("")
TopologicalSort(AdjMat, n)
