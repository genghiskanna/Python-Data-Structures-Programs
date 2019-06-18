#include <stdio.h>
#include <stdlib.h>
struct Node
{
int rowNum;
int columnNum;
int value;
struct Node* nextRow;
struct Node* nextColumn;
};
struct Node *start_Row1[50],*start_Row2[50],*start_Row3[50],*start_RowDisp[50];
struct Node *start_Column1[50],*start_Column2[50],*start_Column3[50];
struct Node *newNode,*temp,*previous;

void createRowHeader(int row,struct Node** start_Row)
    {
        int i;
        for(i=1;i<=row;i++)
        {
            newNode=(struct Node *)malloc(sizeof(struct Node));
            start_Row[i]=newNode;
            start_Row[i]->rowNum=i;
            start_Row[i]->columnNum=0;
            start_Row[i]->nextRow=start_Row[i];
            start_Row[i]->nextColumn=NULL;
        }
    }

void createColumnHeader(int col,struct Node **start_Column)
    {
        int i;
        for(i=1;i<=col;i++)
        {
            newNode=(struct Node *)malloc(sizeof(struct Node));
            start_Column[i]=newNode;
            start_Column[i]->rowNum=0;
            start_Column[i]->columnNum=i;
            start_Column[i]->nextRow=NULL;
            start_Column[i]->nextColumn=start_Column[i];
        }
    }

void CreateSparseMatrix(int row,int col,struct Node **start_Row,struct Node **start_Column)
{
    int no,r,c,x;
 createRowHeader(row,start_Row);
 createColumnHeader(col,start_Column);
 printf("\nEnter the no of elements:");
 scanf("%d",&no);
 while(no>0)
 {
    printf("Enter row number,column number, value:");
    scanf("%d%d%d",&r,&c,&x);
    no--;
    newNode=(struct Node *)malloc(sizeof(struct Node));
    newNode->rowNum=r;
    newNode->columnNum=c;
    newNode->value=x;
    temp=start_Row[r]->nextRow;
    previous=start_Row[r];
    while(temp!=start_Row[r] && temp->columnNum<c)
    {
        previous=temp;
        temp=temp->nextRow;
    }
    previous->nextRow=newNode;
    newNode->nextRow=temp;
    temp=start_Column[c]->nextColumn;
    previous=start_Column[c];
    while(temp!=start_Column[c] && temp->rowNum<r)
    {
        previous=temp;
        temp=temp->nextColumn;
    }
    previous->nextColumn=newNode;
    newNode->nextColumn=temp;
 }
 displaySparse(start_Row,row);

}

void Addition_SparseMatrix(int row,int col)
{
struct Node * temp1,*temp2,*tempRow,*tempColumn[50];
int i;
createRowHeader(row,start_Row3);
createColumnHeader(col,start_Column3);
printf("\nSparse Matrix after Addition");
for(i=1;i<=col;i++)
{
    tempColumn[i]=start_Column3[i];
}
for(i=1;i<=row;i++)
{
temp1=start_Row1[i]->nextRow;

temp2=start_Row2[i]->nextRow;
tempRow=start_Row3[i];
printf("\ni = %d",i);
while(temp1!=start_Row1[i]&&temp2!=start_Row2[i])
{
    newNode=(struct Node *)malloc(sizeof(struct Node));
    newNode->nextRow=start_Row3[i];
    newNode->nextColumn=start_Column3[i];
    if(temp1->columnNum==temp2->columnNum)
    {
        newNode->value=temp1->value+temp2->value;
        newNode->rowNum=temp1->rowNum;
        newNode->columnNum=temp1->columnNum;
        temp1=temp1->nextRow;
        temp2=temp2->nextRow;
    }
    else if(temp1->columnNum<temp2->columnNum)
    {
        newNode->value=temp1->value;
        newNode->rowNum=temp1->rowNum;
        newNode->columnNum=temp1->columnNum;
        temp1=temp1->nextRow;
    }
    else
    {
        newNode->value=temp2->value;
        newNode->rowNum=temp2->rowNum;
        newNode->columnNum=temp2->columnNum;
        temp2=temp2->nextRow;
    }
    tempRow->nextRow=newNode;
    tempRow=tempRow->nextRow;
    tempColumn[newNode->columnNum]->nextColumn=newNode;
    tempColumn[newNode->columnNum]=tempColumn[newNode->columnNum]->nextColumn;
}
if(temp1!=start_Row1[i] && temp2==start_Row2[i])
{

    while(temp1!=start_Row1[i])
    {
    newNode=(struct Node *)malloc(sizeof(struct Node));
    newNode->nextRow=start_Row3[i];
    newNode->nextColumn=start_Column3[i];
    newNode->value=temp1->value;
    newNode->rowNum=temp1->rowNum;
    newNode->columnNum=temp1->columnNum;
    temp1=temp1->nextRow;
    tempRow->nextRow=newNode;
    tempRow=tempRow->nextRow;
    tempColumn[newNode->columnNum]->nextColumn=newNode;
    tempColumn[newNode->columnNum]=tempColumn[newNode->columnNum]->nextColumn;
    }
}
else if(temp1==start_Row1[i] && temp2!=start_Row2[i])
{

  while(temp2!=start_Row2[i])
    {
    newNode=(struct Node *)malloc(sizeof(struct Node));
    newNode->nextRow=start_Row3[i];
    newNode->nextColumn=start_Column3[i];
    newNode->value=temp2->value;
    newNode->rowNum=temp2->rowNum;
    newNode->columnNum=temp2->columnNum;
    temp2=temp2->nextRow;
    tempRow->nextRow=newNode;
    tempRow=tempRow->nextRow;
    tempColumn[newNode->columnNum]->nextColumn=newNode;
    tempColumn[newNode->columnNum]=tempColumn[newNode->columnNum]->nextColumn;
    }
}
}
displaySparse(start_Row3,row);
}

void displaySparse(struct Node **start_RowDisp,int row)
	{
		struct Node *temp1;
        int i;
		for( i=1;i<=row;i++)
		{
			if(start_RowDisp[i]==NULL)
			{
				break;
			}
			temp1=start_RowDisp[i]->nextRow;
			while((temp1!=start_RowDisp[i])&&(start_RowDisp[1]!=NULL))
			{

				printf("\nRow: %d     Column: %d      Value: %d",temp1->rowNum,temp1->columnNum,temp1->value);
				temp1=temp1->nextRow;
			}
		}
	}


int main()
{
    int row,col;
    printf("Enter the number of rows and columns in the sparse matrix");
    scanf("%d%d",&row,&col);
    printf("\nFirst Matrix");
    CreateSparseMatrix(row,col,&start_Row1,&start_Column1);
    printf("\nSecond Matrix");

    CreateSparseMatrix(row,col,&start_Row2,&start_Column2);

    Addition_SparseMatrix(row,col);
}
