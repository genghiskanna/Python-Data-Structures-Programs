# getting dimension of matrix


row = int(input("Enter Row : "))
col = int(input("Enter Column : "))
col2 = int(input("Enter Column of second matrix : "))

matrix1 = []
matrix2 = []

# taking elements of first matrix

print("Enter elements of first matrix")
for i in range(0, row):
    temp = []
    for j in range(0, col):
        print("Enter : %d , %d" % (i, j))
        temp.append(int(input()))
    matrix1.append(temp)


# taking elements of second matrix
print("Enter elements of second matrix")
for i in range(0, col):
    temp = []
    for j in range(0, col2):
        print("Enter : %d , %d" % (i, j))
        temp.append(int(input()))
    matrix2.append(temp)


# multiplication
multi_matrix = []
for i in range(0, row):
    temp = []
    for j in range(0, col):
        sum1 = 0
        for k in range(0, col2):
            sum1 = sum1 + (matrix1[i][k] * matrix2[k][j])
        temp.append(sum1)
    multi_matrix.append(temp)
print "matrix1 x matrix 2 =", multi_matrix
