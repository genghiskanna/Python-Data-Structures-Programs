from __future__ import print_function


queue = []


def BFSTraversal(AdjMat, n):
    State = [0] * 10
    BFS = [0] * 10
    flag = 0
    i = 0
    # Possible States are 0,1,2. 0-Not Visited. 1-Added to Queue. 2-Visited
    for j in range(0, n):
        State[j] = 0
    queue.append(0)
    State[0] = 1
    while flag != 1:
        while (len(queue) != 0):
            # queue.pop(0) removes the first element
            front_vertex = queue.pop(0)
            print("BFS : %d\t" % front_vertex)
            BFS[i] = front_vertex
            i += 1
            State[front_vertex] = 2
            for j in range(0, n):
                if (AdjMat[front_vertex][j] != 0 and not(
                        State[j] == 1 or State[j] == 2)):
                    print("In queue : %d" % j)
                    queue.append(j)
                    State[j] = 1

        for j in range(0, n):
            if State[j] == 0:
                queue.append(j)
                State[j] = 1
                flag = 0
                break
            else:
                flag = 1

    print("\n Vertices traversed using BFS:")
    for i in range(0, n):
        print(" %d " % (BFS[i] + 1))


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
print("Adjacency Matrix")
for i in range(0, n):
    for j in range(0, n):
        print(" %d " % AdjMat[i][j])

BFSTraversal(AdjMat, n)
