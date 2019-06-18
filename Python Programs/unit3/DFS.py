from __future__ import print_function

stack = []


def DFSTraversal(AdjMat, n):
    State = [0] * 10
    DFS = [0] * 10
    flag, i = 0, 0
    # Possible States are 0,1,2. 0-Not Visited. 1-Added to Queue. 2-Visited
    stack.append(0)
    State[0] = 1
    while True:
        while len(stack) != 0:
            front_vertex = stack.pop()
            print("DFS : %d" % front_vertex)
            DFS[i] = front_vertex
            i += 1
            State[front_vertex] = 2
            for j in range(0, n):
                if AdjMat[front_vertex][j] != 0 and not (
                        State[j] == 1 or State[j] == 2):
                    print("In stack : %d" % j)
                    stack.append(j)
                    State[j] = 1
        for j in range(0, n):
            if State[j] == 0:
                stack.append(j)
                State[j] = 1
                flag = 0
                break
            else:
                flag = 1
        if flag == 1:
            break
    print("Vertices traversed using DFS:")
    print(DFS[0:n])


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
    print("")
    for j in range(0, n):
        print(" %d " % AdjMat[i][j], end="")
print("")
DFSTraversal(AdjMat, n)
