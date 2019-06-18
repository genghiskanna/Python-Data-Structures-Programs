# getting dimension of matrix


row = int(input("Enter Row : "))
col = int(input("Enter Column : "))

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
for i in range(0, row):
    temp = []
    for j in range(0, col):
        print("Enter : %d , %d" % (i, j))
        temp.append(int(input()))
    matrix2.append(temp)


# adding

add_matrix = []
for i in range(0, row):
    temp = []
    for j in range(0, col):
        # making a addition matrix's column to append
        # making a 1D matrix with elements as sum of elements of
        # respective columns of both matrices

        temp.append(matrix1[i][j] + matrix2[i][j])
    add_matrix.append(temp)
print "Addition of matrix is", add_matrix
