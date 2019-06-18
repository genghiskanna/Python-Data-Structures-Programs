from __future__ import print_function


class Node:

    def __init__(self, rowNum=None, colNum=None,
                 value=None, nRow=None, nCol=None):
        self.rowNum = rowNum
        self.colNum = colNum
        self.value = value
        self.nRow = nRow
        self.nCol = nCol


start_Row1 = []
start_Row2 = []
start_Row3 = []
start_RowDisp = []
start_Column1 = []
start_Column2 = []
start_Column3 = []
newNode = Node()
temp = Node()
previous = Node()


def createRowHeader(row, start_Row):
    for i in range(0, row):
        start_Row.append(Node(rowNum=i, colNum=0, nRow=None, nCol=None))
        start_Row[i].nRow = start_Row[i]


def createColumnHeader(col, start_Column):
    for i in range(0, col):
        start_Column.append(Node(rowNum=0, colNum=i, nRow=None, nCol=None))
        start_Column[i].nCol = start_Column[i]


def CreateSparseMatrix(row, col, start_Row, start_Column):
    createRowHeader(row, start_Row)
    createColumnHeader(col, start_Column)
    no = int(input("Enter the no of elements:"))
    while no > 0:
        print("Enter row number,column number, value:")
        r = int(input())
        c = int(input())
        x = int(input())
        no -= 1
        newNode = Node()
        newNode.rowNum = r
        newNode.colNum = c
        newNode.value = x
        temp = start_Row[r].nRow
        previous = start_Row[r]
        while (temp != start_Row[r] and temp.colNum < c):
            previous = temp
            temp = temp.nRow

        previous.nRow = newNode
        newNode.nRow = temp
        temp = start_Column[c].nCol
        previous = start_Column[c]
        while temp != start_Column[c] and temp.rowNum < r:
            previous = temp
            temp = temp.nCol

        previous.nCol = newNode
        newNode.nCol = temp
        displaySparse(start_Row, row)


def Addition_SparseMatrix(row, col):
    # global
    tempColumn = []
    temp1 = Node()
    temp2 = Node()
    tempRow = Node()
    createRowHeader(row, start_Row3)
    createColumnHeader(col, start_Column3)
    print("Sparse Matrix after Addition")
    for i in range(0, col):
        tempColumn.append(start_Column3[i])
    for i in range(0, row):
        temp1 = start_Row1[i].nRow
        temp2 = start_Row2[i].nRow
        tempRow = start_Row3[i]
        print("i = %d" % i)
        while temp1 != start_Row1[i] and temp2 != start_Row2[i]:
            newNode = Node(nRow=start_Row3[i], nCol=start_Column3[i])
            if (temp1.colNum == temp2.colNum):
                newNode.value = temp1.value + temp2.value
                newNode.rowNum = temp1.rowNum
                newNode.colNum = temp1.colNum
                temp1 = temp1.nRow
                temp2 = temp2.nRow
            elif temp1.colNum < temp2.colNum:
                newNode.value = temp1.value
                newNode.rowNum = temp1.rowNum
                newNode.colNum = temp1.colNum
                temp1 = temp1.nRow
            else:
                newNode.value = temp2.value
                newNode.rowNum = temp2.rowNum
                newNode.colNum = temp2.colNum
                temp2 = temp2.nRow
            tempRow.nRow = newNode
            tempRow = tempRow.nRow
            tempColumn[newNode.colNum].nCol = newNode
            tempColumn[newNode.colNum] = tempColumn[newNode.colNum].nCol
        if temp1 != start_Row1[i] and temp2 == start_Row2[i]:
            while (temp1 != start_Row1[i]):
                newNode = Node()
                newNode.nRow = start_Row3[i]
                newNode.nCol = start_Column3[i]
                newNode.value = temp1.value
                newNode.rowNum = temp1.rowNum
                newNode.colNum = temp1.colNum
                temp1 = temp1.nRow
                tempRow.nRow = newNode
                tempRow = tempRow.nRow
                tempColumn[newNode.colNum].nCol = newNode
                tempColumn[newNode.colNum] = tempColumn[newNode.colNum].nCol
        elif temp1 == start_Row1[i] and temp2 != start_Row2[i]:
            while (temp2 != start_Row2[i]):
                newNode = Node()
                newNode.nRow = start_Row3[i]
                newNode.nCol = start_Column3[i]
                newNode.value = temp2.value
                newNode.rowNum = temp2.rowNum
                newNode.colNum = temp2.colNum
                temp2 = temp2.nRow
                tempRow.nRow = newNode
                tempRow = tempRow.nRow
                tempColumn[newNode.colNum].nCol = newNode
                tempColumn[newNode.colNum] = tempColumn[newNode.colNum].nCol

    displaySparse(start_Row3, row)


def displaySparse(start_RowDisp, row):
    temp1 = Node()
    for i in range(0, row):
        if start_RowDisp[i] is None:
            break
        temp1 = start_RowDisp[i].nRow
        while temp1 != start_RowDisp[i] and start_RowDisp[1] is not None:
            print("Row: %d\tColumn: %d\tValue: %d" %
                  (temp1.rowNum, temp1.colNum, temp1.value))
            temp1 = temp1.nRow


print("Enter the number of rows and columns in the sparse matrix")
row = int(input())
col = int(input())
print("First Matrix")
CreateSparseMatrix(row, col, start_Row1, start_Column1)
print("Second Matrix")
CreateSparseMatrix(row, col, start_Row2, start_Column2)
Addition_SparseMatrix(row, col)
